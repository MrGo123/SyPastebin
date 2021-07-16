package top.zy68.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IpUtil
 * @Description get client ip （可穿透代理）
 * @Author Sustart
 * @Date2021/1/28 13:41
 * @Version 1.0
 **/
@Component
public class IpUtil {

    public static String getIpAddress(HttpServletRequest request) {

        //get ip
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // remove the ":" from ip.
        String[] ipStrs = ip.split(":");
        StringBuilder newIp = new StringBuilder();
        for (String string : ipStrs) {
            newIp.append(string);
        }

        return newIp.toString();
    }
}
