package top.zy68.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "保存控制器")
@RestController
public class SaveController {
    @Autowired
    private HandleDataService handleDataService;
    /**
     * Handling the data from frontend by ajax
     * @param pasteCode
     * @param saveTime
     * @param request
     * @return String
     */
    @ApiOperation(tags = "保存粘贴内容的接口",value = "根据传入的信息，将粘贴内容保存后返回可访问链接",response = String.class)
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String getPasteData(@RequestParam(value = "pasteCode") String pasteCode,
                               @RequestParam(value = "saveTime") int saveTime,
                               HttpServletRequest request) {
        // 通过ipUtil拿到client的ip，并将此IP直接传给数据生成服务。
        String clientIp = IpUtil.getIpAddress(request);


        // return "done";
        return handleDataService.generateRecord(saveTime,pasteCode,clientIp);
    }



}
