package top.zy68.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.zy68.Service.GenerateShortLinkService;
import top.zy68.Utils.Base62EncodingUtil;

import javax.annotation.Resource;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName GenerateShortLinkServiceImpl
 * @Description generate shortLink
 * @Author Sustart
 * @Date2021/1/25 11:39
 * @Version 1.0
 **/
@Service("GenerateShortLinkService")
public class GenerateShortLinkServiceImpl implements GenerateShortLinkService {

    @Override
    public String encryptByMd5DigestUtils(String clientIpTimestamp) {
        return DigestUtils.md5DigestAsHex(clientIpTimestamp.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getShortLinkFromBase62Encoding(String resultOfMd5) {
        return Base62EncodingUtil.getSevenCharacters(resultOfMd5);
    }
}
