package top.zy68.Config;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DruidConfigTest {

    @Autowired
    DataSource dataSource;

    @Test
    void druidDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;

        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        conn.close();

    }
}