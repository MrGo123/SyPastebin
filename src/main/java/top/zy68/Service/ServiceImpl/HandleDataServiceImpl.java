package top.zy68.Service.ServiceImpl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.Dao.PasteMapper;
import top.zy68.Model.Paste;
import top.zy68.Service.GenerateShortLinkService;
import top.zy68.Service.HandleDataService;
import top.zy68.Service.MongoDbService;


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
     * 1. 若用户有传入自定义的短URL，先查找MySQL中看看有没有？没有，允许插入；有，则反馈给用户更改或选择自动生成。——待实现
     * 2. 自动生成——取ip和时间戳，通过md5和base62生成。
     * 3. 检测MySQL中是否已存在该短URL。
     *
     * @param saveTime
     * @param pasteCode
     * @param clientIp
     * @return
     */
    @Override
    public String generateRecord(int saveTime, String pasteCode, String clientIp) {

        // todo1 根据saveTime，通过一个方法确定保存的时间
        Date createDate = new Date();
        paste.setExpirationTime(calculateExpirationDate(saveTime,createDate));
        paste.setCreateTime(createDate);


        String shortLink = "";
        // 短URL生成服务
        while (true) {
            // 生成IP和时间戳
            String ipTimestamp = clientIp + System.currentTimeMillis();

            // 使用md5和Base62生成一个shortLink
            shortLink = generateShortLinkService.getShortLinkFromBase62Encoding(
                    generateShortLinkService.encryptByMd5DigestUtils(ipTimestamp));

            // 判断生成的shortLink是否够7个字符，不够则重新生成。正常不会发生，除非md5生成的散列码转换为十进制数过小。
            if (shortLink.length() != 7) {
                continue;
            }

            // 检查mysql是否已存在此shortLink
            Paste tempPaste = pasteMapper.selectByPrimaryKey(shortLink);
            if (tempPaste == null) {
                paste.setShortLink(shortLink);
                break;
            }
        }

        // 数据保存到MongoDB中
        try {
            String objectId = mongoDbService.insertDocument(pasteCode);
            if (objectId != null) {
                paste.setPastePath(objectId);
            }
        } catch (Exception e) {
            LOGGER.error("插入MongoDB发送异常");
        }

        // 数据保存到MySQL中
        try {
            pasteMapper.insert(paste);
        } catch (Exception e) {
            LOGGER.error("用户插入数据出现异常，可能失败了！！！");
        }


        return "http://localhost:8080/api/" + shortLink;
    }

    /**
     * 根据创建时间和保存时间计算到期时间并返回
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
