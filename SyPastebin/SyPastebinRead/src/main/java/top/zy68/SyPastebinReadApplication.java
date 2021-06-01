package top.zy68;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ZY
 */
@EnableScheduling
@SpringBootApplication
public class SyPastebinReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyPastebinReadApplication.class, args);
    }

}
