package top.zy68.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.zy68.service.ReturnDataService;
import top.zy68.vo.ResultVO;

/**
 * @ClassName ShowController
 * @Description result data controller
 * @Author Sustart
 * @Date2021/2/1 14:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("api")
public class ShowController {

    @Autowired
    ReturnDataService returnDataService;

    @RequestMapping(value = "/{shortLink}",method = RequestMethod.GET)
    public ResultVO showResult(@PathVariable(value = "shortLink") String shortLink) {

        if (shortLink == null || shortLink.length() != 7) {
            return new ResultVO(401,"参数有误，请修改",null);
        }

        return returnDataService.returnDataHandling(shortLink);
    }
}
