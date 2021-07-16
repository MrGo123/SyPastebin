package top.zy68.service.serviceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zy68.service.TimeTaskService;


@SpringBootTest
class TimeTaskServiceImplTest {

    @Autowired
    TimeTaskService timeTaskService;


    @Test
    void cleanOverdueData() {
        timeTaskService.cleanOverdueData();
    }
}