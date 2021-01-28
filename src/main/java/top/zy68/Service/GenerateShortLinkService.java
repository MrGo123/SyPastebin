package top.zy68.Service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface GenerateShortLinkService {
    String encryptByMd5DigestUtils(String clientIpTimestamp);
    String getShortLinkFromBase62Encoding(String resultOfMd5);
}
