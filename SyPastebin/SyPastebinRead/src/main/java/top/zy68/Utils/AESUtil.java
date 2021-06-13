package top.zy68.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 加密方法，是对称的密码算法(加密与解密的密钥一致)，这里使用最大的 256 位的密钥
 */
@Component
public class AESUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);

    /**
     * 利用密钥sKey对密文进行解密，返回解密后的明文
     *
     * @param originCipherText 原始密文（被Base64编码过）
     * @param sKey             shortLink
     * @return
     */
    public static String decrypt(String originCipherText, String sKey) {
        try {
            byte[] cipherText = new BASE64Decoder().decodeBuffer(originCipherText);
            // 由shortLink经过MD5散列得到128b，作为加密密钥
            SecretKeySpec skeySpec = new SecretKeySpec(DigestUtils.md5Digest(sKey.getBytes()), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] clearTextByte = cipher.doFinal(cipherText);
            return new String(clearTextByte);
        } catch (Exception e) {
            LOGGER.error("AES decrypts exception!!!");
            return null;
        }
    }
}
