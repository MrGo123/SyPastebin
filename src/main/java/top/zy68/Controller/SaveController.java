package top.zy68.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param code
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void getPasteData(@RequestParam(value = "paste_code") String code) {
        System.out.println(code);

    }
}
