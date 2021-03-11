package top.zy68.tasksInBackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.zy68.Service.TimeTaskService;
// 使用Spring线程执行，可以改用线程池
/**
 * @ClassName ScheduledTasks
 * @Description start task when the application is booted
 * @Author Sustart
 * @Date2021/2/25 12:05
 * @Version 1.0
 **/

@Component
public class ScheduledTasks{
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    TimeTaskService timeTaskService;

    @Scheduled(fixedDelay = 2000)
    public void cleanOverdueData(){
        timeTaskService.cleanOverdueData();
    }

}
