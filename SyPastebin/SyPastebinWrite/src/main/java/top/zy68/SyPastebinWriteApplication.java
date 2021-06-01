package top.zy68;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ZY
 */
@EnableScheduling
@SpringBootApplication
public class SyPastebinWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyPastebinWriteApplication.class, args);
    }

}
