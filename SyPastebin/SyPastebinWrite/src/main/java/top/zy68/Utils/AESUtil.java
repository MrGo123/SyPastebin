package top.zy68.Utils;

/*
  @ClassName AESUtil
 * @Description AES对文本加密解密工具类实现
 * @Author Sustart
 * @Date2021/5/19 22:52
 * @Version 1.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * AES 加密方法，这里使用 128位 的密钥
 */
@Component
public class AESUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);
    /**
     * 利用密钥sKey对明文进行加密，返回加密后且经过Base64二次编码后的密文
     * @param clearText 明文
     * @param sKey 128b密钥
     * @return
     */
    public static String encrypt(String clearText, String sKey) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(DigestUtils.md5Digest(sKey.getBytes()), "AES");
            //PKCS5Padding 填充模式：若明文不是128b则进行填充
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(clearText.getBytes(StandardCharsets.UTF_8));
            // 借助Base64进行编码，相当于二次加密
            return new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            LOGGER.error("AES encrypts exception!!!");
            return null;
        }
    }
}