package top.zy68.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import top.zy68.Service.HandleDataService;
import top.zy68.Utils.IpUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SaveController
 * @Description Save paste code controller
 * @Author Sustart
 * @Date2021/1/21 14:41
 * @Version 1.0
 **/
@Controller
public class SaveController {
    @Autowired
    private HandleDataService handleDataService;

    /**
     * home page controller
     * Mapping to index.html
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String indexCtrl() {
        return "forward:index.html";
    }

    /**
     * Handling the data from frontend by ajax
     *
     * @param pasteCode
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String getPasteData(@RequestParam(value = "pasteCode") String pasteCode,
                               @RequestParam(value = "saveTime") int saveTime,
                               HttpServletRequest request) {



        String clientIp = IpUtil.getIpAddr(request);
        System.out.println(pasteCode + saveTime);

        //调用数据处理及返回结果服务

        return handleDataService.generateRecord(saveTime,pasteCode,clientIp);
    }
}
