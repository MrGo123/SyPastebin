package top.zy68.Model;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Paste
 * @Description the object of paste
 * @Author Sustart
 * @Date2021/1/21 14:35
 * @Version 1.0
 **/

@Data
public class Paste {
    private String shortLink;
    private  int expirationTime;
    private Date createTime;
    private String pastePath;
}
