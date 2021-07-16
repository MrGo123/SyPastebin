package top.zy68.utils;

import org.springframework.stereotype.Component;


/**
 * @ClassName Base62EncodingUtil
 * @Description Base62EncodingUtil
 * @Author Sustart
 * @Date2021/1/29 11:33
 * @Version 1.0
 **/
@Component
public class Base62EncodingUtil {
    private static char[] encodes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
            .toCharArray();

    /**
     * 根据给出的数值，计算Base62字符。即将十进制转换为六十二进制。
     * @param number
     * @return
     */
    public static String encodingBase62(int number) {
        StringBuilder res = new StringBuilder();
        while (number != 0) {
            res.append(encodes[number % 62]);
            number /= 62;
        }
        return res.reverse().toString();
    }

    /**
     * 将从md5散列得到的128bits的散列值划分为四个小组，每个小组4Byte。将小组当十六进制转换为十进制的Long型，
     * 将得到的十进制和0x3fffffff(30个1)进行与操作，避免数值太大，再将结果转为int型。
     * 将int型的数值经过Base62编码，得到字符串。
     * 将四个字符串拼接后取前7个字符作为shortLink
     * @param hex128bits
     * @return
     */
    public static String getSevenCharacters(String hex128bits) {
        String[] group = new String[4];
        StringBuilder res = new StringBuilder();

        // 将128bit即16Byte划分为四个小组，每个小组四个Byte
        for (int i = 0, j = 0; i <= hex128bits.length() && j < group.length; i += 8) {
            group[j++] = hex128bits.substring(i, i + 8);
        }

        for (String s : group) {
            // 将四个Byte的String转为int型,每个int结果调用Base62算法生成String
            res.append(Base62EncodingUtil.encodingBase62((int) Long.parseLong(s, 16) & 0x3fffffff));
        }

        return res.substring(0,7).toString();
    }

}
