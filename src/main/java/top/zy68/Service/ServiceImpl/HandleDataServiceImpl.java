package top.zy68.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.Dao.PasteMapper;
import top.zy68.Model.Paste;
import top.zy68.Service.GenerateShortLinkService;
import top.zy68.Service.HandleDataService;
import top.zy68.Service.MongoDbService;


import java.util.Date;

/**
 * @ClassName HandleDataServiceImpl
 * @Description handle the data from user
 * @Author ZY
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

    @Override
    public String generateRecord(int saveTime, String pasteCode, String clientIp) {

        //todo1 根据saveTime，通过一个方法确定保存的时间
        // paste.setExpirationTime(saveTime);

        paste.setCreateTime(new Date());

        // todo使用正则提取ip字符串的数字
        // String ipTimestamp = ""+ System.currentTimeMillis();
        // todo2 使用md5生成一个shortLink
        // String shortLink = generateShortLinkService.getShortLinkFromBase62Encoding(generateShortLinkService.encryptByMd5DigestUtils(ipTimestamp));

        // todo查mysql是否已存在此shortLink
        // pasteMapper.selectByPrimaryKey(shortLink);
        // paste.setShortLink(shortLink);

        // todo3 存储在对象存储中的路径，即存objectid，存code时返回id即可。
        String objectId = mongoDbService.insertDocument(pasteCode);
        if (objectId != null) {
            paste.setPastePath(objectId);
        }

        // int flag = pasteMapper.insert(paste);
        // if (flag == 1) {
        //     System.out.println("insert success");
        // }

        return "done well";
    }

}
