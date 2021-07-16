package top.zy68.service.serviceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.dao.PasteMapper;
import top.zy68.model.Paste;
import top.zy68.service.GenerateShortLinkService;
import top.zy68.service.HandleDataService;
import top.zy68.service.MongoDbService;
import top.zy68.utils.AESUtil;


import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName HandleDataServiceImpl
 * @Description handle the data from user
 * @Author Sustart
 * @Date2021/1/24 13:14
 * @Version 1.0
 **/
@Service("HandleDataService")
public class HandleDataServiceImpl implements HandleDataService {

    @Autowired
    PasteMapper pasteMapper;

    @Autowired
    MongoDbService mongoDbService;

    @Autowired
    GenerateShortLinkService generateShortLinkService;

    @Autowired
    Paste paste;

    private static final Logger LOGGER = LoggerFactory.getLogger(HandleDataServiceImpl.class);

    /**
     * 流程逻辑：
     * 传入参数：根据得到的保存时间、要保存的粘贴内容、客户端ip、（用户自定义的短URL）
     * 一、生成短URL：
     * 1. 若用户有传入自定义的短URL，先查找MySQL中看看有没有？没有，允许插入；有，则自动生成。
     * 2. 自动生成——取ip和时间戳，通过md5和base62生成。
     * 3. 检测MySQL中是否已存在该短URL。
     *
     * @param saveTime
     * @param pasteCode
     * @param clientIp
     * @return
     */
    @Override
    public String generateRecord(int saveTime, String pasteCode, String userDefinedShortLink, String clientIp) {

        // 1. 根据saveTime，保存创建时间和过期时间
        Date createDate = new Date();
        paste.setCreateTime(createDate);
        paste.setExpirationTime(calculateExpirationDate(saveTime, createDate));

        // 2. 短URL生成服务：先判断 userDefinedShortLink 是否合法，否则生成。
        String shortLink = "";
        if (userDefinedShortLink != null && generateShortLinkService.shortLinkNotExist(userDefinedShortLink)) {
            shortLink = userDefinedShortLink;
        } else {
            shortLink = generateShortLinkService.generateShortLink(clientIp);
        }
        paste.setShortLink(shortLink);

        // 对粘贴的内容加密
        String tmpPasteCode = pasteCode;
        try {
            pasteCode = AESUtil.encrypt(pasteCode, shortLink);
        } catch (NullPointerException e) {
            // 加密漏洞：如果AES加密失败返回null，那就不进行加密，明文保存。
            pasteCode = tmpPasteCode;
            e.printStackTrace();
        }

        // todo：从这里开始，为了保证MongoDB和MySQL数据存储的一致性，应当增加事务处理。

        // 3. pasteCode数据保存到MongoDB中
        try {
            String objectId = mongoDbService.insertDocument(pasteCode);
            // String objectId = "mongoDbService.insertDocument(pasteCode)";
            if (objectId != null) {
                paste.setPastePath(objectId);
            }
        } catch (Exception e) {
            LOGGER.error("插入MongoDB发送异常");
        }

        // 4. 数据保存到MySQL中
        try {
            pasteMapper.insert(paste);
        } catch (Exception e) {
            LOGGER.error("用户插入数据出现异常，可能失败了！！！");
        }

        return shortLink;
    }

    /**
     * 根据创建时间和保存时间计算到期时间并返回
     *
     * @param saveTime
     * @param createDate
     * @return
     */
    private Date calculateExpirationDate(int saveTime, Date createDate) {
        Calendar time = Calendar.getInstance();
        time.setTime(createDate);

        /**
         * 0——永不过期
         * 1——一天
         * 2——两天
         * 7——一周
         * 8——一个月
         * 可扩展
         */

        if (saveTime == 0) {
            return createDate;
        } else if (saveTime == 8) {
            time.add(Calendar.MONTH, 1);
        } else {
            time.add(Calendar.DAY_OF_WEEK, saveTime);
        }

        return time.getTime();
    }
}
