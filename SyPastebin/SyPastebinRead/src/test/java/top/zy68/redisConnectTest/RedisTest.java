package top.zy68.redisConnectTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import top.zy68.model.Paste;

import java.util.Date;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Author Sustart
 * @Date2021/8/8 21:49
 * @Version 1.0
 **/
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        ValueOperations<String, Paste> operations = redisTemplate.opsForValue();
        Paste paste = new Paste();
        paste.setPastePath("123ghhj");
        paste.setCreateTime(new Date());
        paste.setExpirationTime(new Date());
        paste.setShortLink("uuuiuuu");
        operations.set("passss",paste);
        System.out.println(paste);
    }

    @Test
    public void getRedisObject(){
        ValueOperations<String, Paste> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey("passss");
        if (hasKey) {
            Paste paste = operations.get("passss");
            System.out.println(paste);
        }
    }
}
