package top.zy68.Service.ServiceImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.zy68.Service.GenerateShortLinkService;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName GenerateShortLinkServiceImpl
 * @Description generate shortLink
 * @Author Sustart
 * @Date2021/1/25 11:39
 * @Version 1.0
 **/
@Service
@Component
public class GenerateShortLinkServiceImpl implements GenerateShortLinkService {

    @Override
    public String encryptByMd5DigestUtils(String clientIpTimestamp) {
        String md5 = "";
        md5 = DigestUtils.md5DigestAsHex(clientIpTimestamp.getBytes(StandardCharsets.UTF_8));
        return md5;
    }

    @Override
    public String getShortLinkFromBase62Encoding(String resultOfMd5) {

        return null;
    }
    // public static StringBuffer encodeBase62(byte[] data) {
    //     StringBuffer sb = new StringBuffer(data.length * 2);
    //     int pos = 0, val = 0;
    //     for (int i = 0; i < data.length; i++) {
    //         val = (val << 8) | (data[i] & 0xFF);
    //         pos += 8;
    //         while (pos > 5) {
    //             char c = encodes[val >> (pos -= 6)];
    //             sb.append(
    //                     /**/c == 'i' ? "ia" :
    //                             /**/c == '+' ? "ib" :
    //                             /**/c == '/' ? "ic" : c);
    //             val &= ((1 << pos) - 1);
    //         }
    //     }
    //     if (pos > 0) {
    //         char c = encodes[val << (6 - pos)];
    //         sb.append(
    //                 /**/c == 'i' ? "ia" :
    //                         /**/c == '+' ? "ib" :
    //                         /**/c == '/' ? "ic" : c);
    //     }
    //     return sb;
    // }
    //
    // public static byte[] decodeBase62(char[] data) {
    //     ByteArrayOutputStream baos = new ByteArrayOutputStream(data.length);
    //     int pos = 0, val = 0;
    //     for (int i = 0; i < data.length; i++) {
    //         char c = data[i];
    //         if (c == 'i') {
    //             c = data[++i];
    //             c =
    //                     /**/c == 'a' ? 'i' :
    //                     /**/c == 'b' ? '+' :
    //                     /**/c == 'c' ? '/' : data[--i];
    //         }
    //         val = (val << 6) | decodes[c];
    //         pos += 6;
    //         while (pos > 7) {
    //             baos.write(val >> (pos -= 8));
    //             val &= ((1 << pos) - 1);
    //         }
    //     }
    //     return baos.toByteArray();
    // }
}
