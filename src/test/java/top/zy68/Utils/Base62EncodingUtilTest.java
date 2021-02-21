package top.zy68.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62EncodingUtilTest {

    // @Test
    void encodingBase62() {
        System.out.println(Base62EncodingUtil.encodingBase62(125));
    }

    @Test
    void getSevenCharacters() {
        String hex128bits = "7c477ac6852274e4731f6f59e1b6087c";
        System.out.println(Base62EncodingUtil.getSevenCharacters(hex128bits));
    }
}