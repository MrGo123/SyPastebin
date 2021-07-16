package top.zy68.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.zy68.dao.PasteMapper;
import top.zy68.model.Paste;
import top.zy68.service.GenerateShortLinkService;
import top.zy68.utils.Base62EncodingUtil;
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
    @Autowired
    PasteMapper pasteMapper;

    @Override
    public String encryptByMd5DigestUtils(String clientIpTimestamp) {
        return DigestUtils.md5DigestAsHex(clientIpTimestamp.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getShortLinkFromBase62Encoding(String resultOfMd5) {
        return Base62EncodingUtil.getSevenCharacters(resultOfMd5);
    }
    /**
     * 根据IP和时间戳生成短连接shortLink
     * @param clientIp
     * @return
     */
    @Override
    public String generateShortLink(String clientIp){
        String shortLink = "";

        while (true) {
            // 生成IP和时间戳。+7是为了保证shortLink不符合要求后重新得到的时间戳时间跨度加大，使得新ipTimestamp和之前的有较大差异。
            String ipTimestamp = clientIp + System.currentTimeMillis() + 7;

            // 使用md5和Base62生成一个shortLink
            shortLink = getShortLinkFromBase62Encoding(encryptByMd5DigestUtils(ipTimestamp));

            // 判断生成的shortLink是否够7个字符，不够则重新生成。正常不会发生，除非md5生成的散列码转换为十进制数过小。
            if (shortLink.length() != 7) {
                continue;
            }

            // 检查mysql是否已存在此shortLink
            if (shortLinkNotExist(shortLink)) {
                break;
            }
        }

        return shortLink;
    }

    /**
     * 判断shortLink是否已存在,false-存在；true-不存在
     * @param shortLink
     * @return
     */
    @Override
    public boolean shortLinkNotExist(String shortLink){
        Paste tempPaste = pasteMapper.selectByPrimaryKey(shortLink);
        return tempPaste == null;
    }

}
