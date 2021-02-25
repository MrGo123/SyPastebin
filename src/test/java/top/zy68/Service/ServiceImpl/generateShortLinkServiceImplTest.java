package top.zy68.Service.ServiceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.annotation.ApplicationScope;
import top.zy68.Service.GenerateShortLinkService;
import top.zy68.Utils.Base62EncodingUtil;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootTest
class generateShortLinkServiceImplTest {

    @Autowired
    GenerateShortLinkServiceImpl generateShortLinkService;


    @Test
    void generateByMD5DigestUtils() {
        String hex128bits = generateShortLinkService.encryptByMd5DigestUtils("1921081261261612245885241");
        System.out.println(hex128bits);
    }

    // @Test
    void getShortLinkFromBase62Encoding() {
        // System.out.println(generateShortLinkService.getShortLinkFromBase62Encoding(
        //         generateShortLinkService.encryptByMd5DigestUtils("Marydon")));

        // System.out.println(Arrays.toString(Base62EncodingUtil.decodeBase62("hello")));
    }
}