package top.zy68.model;

import lombok.Data;

/**
 * @ClassName PasteInfoForShow
 * @Description include the basic info of a paste!
 * @Author Sustart
 * @Date2021/2/1 15:08
 * @Version 1.0
 **/
@Data
public class PasteInfoForShow {
    private String shortLink;
    private String expirationTime;
    private String createTime;
    private String pasteCode;
}
