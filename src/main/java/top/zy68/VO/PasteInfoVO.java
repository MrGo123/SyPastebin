package top.zy68.VO;

import lombok.Data;

/**
 * @ClassName PasteInfoVO
 * @Description return data to the frontend
 * @Author Sustart
 * @Date2021/2/1 15:20
 * @Version 1.0
 **/
@Data
public class PasteInfoVO {
    private Integer code;
    private String message;
    private Object data;

    public PasteInfoVO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
