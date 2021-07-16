package top.zy68.utils;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

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