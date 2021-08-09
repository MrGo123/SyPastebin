package top.zy68.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import top.zy68.dao.PasteMapper;
import top.zy68.model.Paste;
import top.zy68.model.PasteInfoForShow;
import top.zy68.service.MongoDbService;
import top.zy68.service.ReturnDataService;
import top.zy68.utils.AESUtil;
import top.zy68.vo.ResultCode;
import top.zy68.vo.ResultVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ReturnDataServiceImpl
 * @Description return data to the view
 * @Author Sustart
 * @Date2021/2/1 14:43
 * @Version 1.0
 **/
@Service("ReturnDataService")
public class ReturnDataServiceImpl implements ReturnDataService {

    @Autowired
    PasteMapper pasteMapper;

    @Autowired
    MongoDbService mongoDbService;

    @Autowired
    RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReturnDataServiceImpl.class);

    /**
     * todo1 根据短url找mysql，查看是否存在该条数据
     * 没有，返回404
     * 有，获取该条粘贴的信息paste，并用paste的pastePath到mongodb拿数据
     * questionTodo 处理mysql访问异常、数据异常等；
     *
     * @param shortLink 短url
     * @return 结果视图对象
     */
    @Override
    public ResultVO returnDataHandling(String shortLink) {
        ValueOperations<String, Paste> valueOperations = redisTemplate.opsForValue();
        Paste paste;
        boolean redisSign = true;

        // 通过 redis 缓存获取
        boolean hasKey = redisTemplate.hasKey(shortLink);
        if (hasKey) {
            paste = valueOperations.get(shortLink);
            LOGGER.info("get paste from redis.");
        } else {
            // 通过 mysql 获取
            paste = pasteMapper.selectByPrimaryKey(shortLink);
            redisSign = false;
            LOGGER.info("get paste from mysql.");
        }

        if (paste == null) {
            LOGGER.info("cannot find the paste.");
            return new ResultVO(ResultCode.SOURCE_IS_LOST, null);
        }

        // 如果不是从redis获取则加入redis，保存至其过期或永久存储
        if (!redisSign) {
            long keepTime = (paste.getExpirationTime().getTime() - paste.getCreateTime().getTime()) / (24*60*60*1000);
            if (keepTime == 0) {
                // 永久存储
                valueOperations.set(shortLink, paste);
            } else {
                // 存储至过期
                valueOperations.set(shortLink, paste, keepTime, TimeUnit.DAYS);
            }
            LOGGER.info("Kept in redis.");
        }

        // 将所有paste信息封装到pasteInfoForShow
        PasteInfoForShow pasteInfoForShow = new PasteInfoForShow();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pasteInfoForShow.setShortLink(paste.getShortLink());
        pasteInfoForShow.setCreateTime(df.format(paste.getCreateTime()));
        pasteInfoForShow.setExpirationTime(df.format(paste.getExpirationTime()));

        // 从mongodb拿数据
        String base64PasteCode = mongoDbService.selectById(paste.getPastePath());
        LOGGER.info("Get data from mongodb.");

        // AES 解密
        try {
            String pasteCode = AESUtil.decrypt(base64PasteCode, shortLink);
            // questionTodo 是否增加数据库异常判断
            pasteInfoForShow.setPasteCode(pasteCode);
        } catch (NullPointerException e) {
            pasteInfoForShow.setPasteCode(base64PasteCode);
            // 如果解密返回null，失败，那么直接返回未解密的内容
            e.printStackTrace();
            LOGGER.info("AES decrypt failed!!");
        }

        return new ResultVO(ResultCode.SUCCESS, pasteInfoForShow);
    }
}
