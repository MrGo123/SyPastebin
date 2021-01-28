package top.zy68.Service.ServiceImpl;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zy68.Service.MongoDbService;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MongoDbServiceImplTest {

    @Autowired
    MongoDbServiceImpl mongoDbService = new MongoDbServiceImpl();

    @Test
    void insertDocument() {
        String str = "pri";
        System.out.println(mongoDbService.insertDocument(str));
    }

    // @Test
    void selectById(){
        String id = "60126fd9e063fd4bdcac91d9";
        System.out.println(mongoDbService.selectById(id));
    }
}