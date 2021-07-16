package top.zy68.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongoDbServiceImplTest {

    @Autowired
    MongoDbServiceImpl mongoDbService = new MongoDbServiceImpl();

    // @Test
    void insertDocument() {
        String str = "pri";
        System.out.println(mongoDbService.insertDocument(str));
    }

    // @Test
    void selectById(){
        String id = "60126fd9e063fd4bdcac91d9";
        System.out.println(mongoDbService.selectById(id));
    }

    // @Test
    void removeById() {
        int res = mongoDbService.removeById("603712687c617b4f2284ef7b");
        System.out.println(res);
    }
}