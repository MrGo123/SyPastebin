package top.zy68.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SaveController
 * @Description TODO
 * @Author sustart
 * @Date2021/1/21 14:41
 * @Version 1.0
 **/
@Controller
public class SaveController {

    /**
     * Main page controller
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
                               @RequestParam(value = "saveTime") int saveTime) {
        System.out.println(pasteCode + saveTime);

        return "http://localhost:8080/show.html";
    }
}
