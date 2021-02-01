package top.zy68.Model;

import lombok.Data;

import java.util.Date;

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
    private Integer expirationTime;
    private Date createTime;
    private String pasteCode;
}
