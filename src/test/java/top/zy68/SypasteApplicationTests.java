package top.zy68;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootTest
class SypasteApplicationTests {

    @Autowired
    DataSource dataSource;

    // @Test
    void contextLoads() throws SQLException {
        System.out.println("connection:" + dataSource.getConnection());
    }

    /**
     * handling the ip
     */
    @Test
    void ipHandlingTest() {
        String ip = "192:168:126:126";
        String[] strs = ip.split(":");
        StringBuilder newstr = new StringBuilder();
        for (String string : strs) {
            newstr.append(string);
        }
        String ipTimestamp = newstr.toString() + String.valueOf(System.currentTimeMillis());
        System.out.println(newstr);
        System.out.println(Arrays.toString(strs));
        System.out.println(ipTimestamp);
    }
}
