package top.zy68.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class AESUtilTest {


    @Test
    void AESEncryptTset() throws NoSuchAlgorithmException {
        String content = "abcdefgwegfgsdfgdsgdfsgsdgwdfgdsf";
        System.out.println(content);

        String sKey = "abcdefg";
        System.out.println(sKey);

        String res = AESUtil.encrypt(content, sKey);
        System.out.println(res);
    }
}