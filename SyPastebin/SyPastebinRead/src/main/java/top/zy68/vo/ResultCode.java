package top.zy68.vo;



/**
 * @ClassName ResultCode
 * @Description A enum Class for http status code. For standard.
 * @Author Sustart
 * @Date2021/7/17 2:20
 * @Version 1.0
 **/
public enum ResultCode {
    // success
    SUCCESS(200,"Successful!"),
    PARAM_IS_INVALID(401,"The parameter is invalid!"),
    SOURCE_IS_LOST(404,"The source is lost!"),
    NULL_POINT_EXCEPTION(500,"null point exception");


    private Integer code;
    private String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer code(){
        return this.code;
    }
    public String message(){
        return this.message;
    }

}
