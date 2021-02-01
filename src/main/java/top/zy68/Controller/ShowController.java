package top.zy68.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zy68.Service.ReturnDataService;
import top.zy68.VO.PasteInfoVO;

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

    @RequestMapping(value = "/{shortLink}")
    public PasteInfoVO showResult(@PathVariable(value = "shortLink") String shortLink) {

        if (shortLink == null || shortLink.length() != 7) {
            return new PasteInfoVO(401,"参数有误，请修改",null);
        }

        // System.out.println(shortLink);
        return returnDataService.returnDataHandling(shortLink);
    }
}
