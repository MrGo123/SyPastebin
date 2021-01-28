package top.zy68.Service.ServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zy68.Service.HandleDataService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HandleDataServiceImplTest {

    @Autowired
    HandleDataService handleDataService;

    @Test
    void generateRecordTest(){
        String res = handleDataService.generateRecord(200,"hello world","192126223168");
        System.out.println(res);
    }
}