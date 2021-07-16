package top.zy68.service;


public interface GenerateShortLinkService {
    /**
     * encoding the IP and timestamp by MD5.
     * @param clientIpTimestamp
     * @return
     */
    String encryptByMd5DigestUtils(String clientIpTimestamp);

    /**
     * generate the 7 characters by Base62 based on the result of MD5.
     * @param resultOfMd5
     * @return
     */
    String getShortLinkFromBase62Encoding(String resultOfMd5);

    /**
     * generate shortLink by clientIp and timestamp.
     * @param clientIp
     * @return
     */
    String generateShortLink(String clientIp);

    /**
     * judge whether the shortLink is existed.
     * @param shortLink
     * @return
     */
    boolean shortLinkNotExist(String shortLink);
}
