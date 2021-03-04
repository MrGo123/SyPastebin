package top.zy68;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SypasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SypasteApplication.class, args);
    }

}
