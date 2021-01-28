package top.zy68.Service;


import org.springframework.stereotype.Component;


public interface HandleDataService {
    String generateRecord(int saveTime,String pasteCode,String clientIp);
}
