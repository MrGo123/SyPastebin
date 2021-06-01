package top.zy68.Service.ServiceImpl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class generateShortLinkServiceImplTest {

    @Autowired
    GenerateShortLinkServiceImpl generateShortLinkService;

    private static final Logger LOGGER = LoggerFactory.getLogger(generateShortLinkServiceImplTest.class);

    @Test
    void testShortLinkNotExist(){
        // String shortLink = "XM7jYci";
        String shortLink = "XM7aaai";

        if (generateShortLinkService.shortLinkNotExist(shortLink)) {
            LOGGER.info("shortLink is not existed");
        }else{
            LOGGER.info("shortLink is existed");
        }
    }

    @Test
    void generateByMD5DigestUtils() {
        String hex128bits = generateShortLinkService.encryptByMd5DigestUtils("1921081261261612245885241");
        System.out.println(hex128bits);
    }

    @Test
    void generateShortLink() {
        String clientIP = "192.168.126.111";
        LOGGER.info(generateShortLinkService.generateShortLink(clientIP));
    }

    @Test
    void getShortLinkFromBase62Encoding() {
        System.out.println(generateShortLinkService.getShortLinkFromBase62Encoding(
                generateShortLinkService.encryptByMd5DigestUtils("Marydon")));
    }
}