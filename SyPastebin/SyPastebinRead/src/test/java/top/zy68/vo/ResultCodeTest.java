package top.zy68.vo;

import org.junit.jupiter.api.Test;

public class ResultCodeTest {

    @Test
    void testCode(){
        ResultVO resultVO = new ResultVO(ResultCode.SUCCESS,666);
        System.out.println(resultVO.toString());
        ResultVO resultVO2 = new ResultVO(ResultCode.PARAM_IS_INVALID,666);
        System.out.println(resultVO2.toString());
    }

}