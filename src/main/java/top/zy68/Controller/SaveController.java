package top.zy68.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import top.zy68.Service.HandleDataService;
import top.zy68.Utils.IpUtil;

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
     * @return String
     */
    @RequestMapping(value = "/")
    public String indexCtrl() {
        return "forward:index.html";
    }

    /**
     * Handling the data from frontend by ajax
     * @param pasteCode
     * @param saveTime
     * @param request
     * @return String
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String getPasteData(@RequestParam(value = "pasteCode") String pasteCode,
                               @RequestParam(value = "saveTime") int saveTime,
                               HttpServletRequest request) {
        // 通过ipUtil拿到client的ip，并将此IP直接传给数据生成服务。
        String clientIp = IpUtil.getIpAddress(request);
        return "done";
        // return handleDataService.generateRecord(saveTime,pasteCode,clientIp);
    }



}
