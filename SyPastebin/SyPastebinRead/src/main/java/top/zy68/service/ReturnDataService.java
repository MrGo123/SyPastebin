package top.zy68.service;

import top.zy68.vo.ResultVO;

public interface ReturnDataService {
    /**
     * handling the request from the client and make a response
     * @return ResultVO
     */
    ResultVO returnDataHandling(String shortLink);
}
