package top.zy68.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.zy68.VO.ResultVO;

/**
 * @ClassName GlobalExceptionHandler
 * @Description handling global exceptions
 * @Author Sustart
 * @Date2021/2/27 23:22
 * @Version 1.0
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //还可以加入其他异常处理，从上往下优先执行

    /**
     * 全局空指针异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleTypeMismatchException(NullPointerException exception) {
        LOGGER.error("空指针异常,{}", exception.getMessage());
        return new ResultVO(500, "空指针异常", null);
    }

    /**
     * 全局异常统一处理
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleUnexpectedServer(Exception exception) {
        LOGGER.error("系统异常", exception);
        return new ResultVO(500, "系统异常，请联系管理员", null);
    }
}
