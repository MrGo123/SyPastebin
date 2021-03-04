package top.zy68.Service;

import top.zy68.VO.ResultVO;

public interface ReturnDataService {
    /**
     * handling the request from the client and make a response
     * @return ResultVO
     */
    ResultVO returnDataHandling(String shortLink);
}
