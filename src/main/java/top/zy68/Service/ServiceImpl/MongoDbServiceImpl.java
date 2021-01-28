package top.zy68.Service.ServiceImpl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import top.zy68.Model.PasteCode;
import top.zy68.Service.MongoDbService;

import javax.annotation.Resource;

/**
 * @ClassName MongoDbServiceImpl
 * @Description CRUD in mongodb
 * @Author Sustart
 * @Date2021/1/28 15:22
 * @Version 1.0
 **/

@Service
public class MongoDbServiceImpl implements MongoDbService {

    @Resource
    MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "pastecode";

    @Override
    public String insertDocument(String code) {

        PasteCode pasteCode = mongoTemplate.save(new PasteCode(code), COLLECTION_NAME);
        return pasteCode.getId();
    }

    @Override
    public String selectById(String id) {
        PasteCode pasteCode = mongoTemplate.findById(id, PasteCode.class, COLLECTION_NAME);
        if (pasteCode != null) {
            return pasteCode.getPasteCode();
        }
        return null;
    }
}
