package top.zy68.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.Dao.PasteMapper;
import top.zy68.Model.Paste;
import top.zy68.Model.PasteInfoForShow;
import top.zy68.Service.MongoDbService;
import top.zy68.Service.ReturnDataService;
import top.zy68.VO.ResultVO;

/**
 * @ClassName ReturnDataServiceImpl
 * @Description return data to the view
 * @Author Sustart
 * @Date2021/2/1 14:43
 * @Version 1.0
 **/
@Service("ReturnDataService")
public class ReturnDataServiceImpl implements ReturnDataService {

    @Autowired
    PasteMapper pasteMapper;

    @Autowired
    MongoDbService mongoDbService;

    /**
     * todo1 根据短url找mysql，查看是否存在该条数据
     * 没有，返回404
     * 有，获取该条粘贴的信息paste，并用paste的pastePath到mongodb拿数据
     * questionTodo 处理mysql访问异常、数据异常等；
     *
     * @param shortLink
     * @return
     */
    @Override
    public ResultVO returnDataHandling(String shortLink) {


        Paste paste = pasteMapper.selectByPrimaryKey(shortLink);

        if (paste == null) {
            return new ResultVO(404, "不存在该粘贴或已过期", null);
        }

        // 将所有paste信息封装到pasteInfoForShow
        PasteInfoForShow pasteInfoForShow = new PasteInfoForShow();

        pasteInfoForShow.setShortLink(paste.getShortLink());
        pasteInfoForShow.setCreateTime(paste.getCreateTime());
        pasteInfoForShow.setExpirationTime(paste.getExpirationTime());

        // 从mongodb拿数据
        // questionTodo 是否增加数据库异常判断
        pasteInfoForShow.setPasteCode(mongoDbService.selectById(paste.getPastePath()));

        return new ResultVO(200, "successful", pasteInfoForShow);
    }
}
