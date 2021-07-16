package top.zy68.vo;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description return data to the frontend
 * @Author Sustart
 * @Date2021/2/1 15:20
 * @Version 1.0
 **/
@Data
public class ResultVO {
    private Integer code;
    private String message;
    private Object data;

    public ResultVO(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }
}
