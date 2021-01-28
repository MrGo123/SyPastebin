package top.zy68.Service.ServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zy68.Service.GenerateShortLinkService;

import javax.annotation.Resource;

class generateShortLinkServiceImplTest {


    GenerateShortLinkService generateShortLinkService = new GenerateShortLinkServiceImpl();

    @Test
    void generateByMD5DigestUtils() {
        System.out.println(generateShortLinkService.encryptByMd5DigestUtils("Marydon"));
    }

    // @Test
    void getShortLinkFromBase62Encoding() {
    }
}