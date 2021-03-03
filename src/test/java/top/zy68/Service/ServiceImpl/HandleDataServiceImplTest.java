package top.zy68.Service.ServiceImpl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zy68.Service.HandleDataService;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HandleDataServiceImplTest {
    private final static Logger log = LoggerFactory.getLogger(HandleDataServiceImplTest.class);

    @Autowired
    HandleDataService handleDataService;

    // @Test
    void generateRecordTest(){
        String res = handleDataService.generateRecord(200,"hello world","192126223168");
        System.out.println(res);
    }

    @Test
    void generateExpirationTimestamp() {
        Date date = new Date();
        log.info(String.valueOf(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DAY_OF_WEEK,1);
        log.info(String.valueOf(calendar.getTime()));

    }
}