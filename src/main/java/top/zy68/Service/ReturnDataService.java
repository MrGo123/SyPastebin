package top.zy68.Service;

import top.zy68.VO.PasteInfoVO;

public interface ReturnDataService {
    /**
     * handling the request from the client and make a response
     * @return PasteInfoVO
     */
    PasteInfoVO returnDataHandling(String shortLink);
}
