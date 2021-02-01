package top.zy68.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.Dao.PasteMapper;
import top.zy68.Model.Paste;
import top.zy68.Model.PasteInfoForShow;
import top.zy68.Service.MongoDbService;
import top.zy68.Service.ReturnDataService;
import top.zy68.VO.PasteInfoVO;

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

    @Override
    public PasteInfoVO returnDataHandling(String shortLink) {


        // todo1 根据短url找mysql，查看是否存在该条数据
        // 没有，返回404
        // 有，获取该条粘贴的信息paste，并用paste的pastePath到mongodb拿数据
        // questionTodo 是否访问异常
        Paste paste = pasteMapper.selectByPrimaryKey(shortLink);
        if (paste == null) {
            return new PasteInfoVO(404, "不存在该粘贴或已过期", null);
        }

        PasteInfoForShow pasteInfoForShow = new PasteInfoForShow();

        pasteInfoForShow.setShortLink(paste.getShortLink());
        pasteInfoForShow.setCreateTime(paste.getCreateTime());
        pasteInfoForShow.setExpirationTime(paste.getExpirationTime());

        // 从mongodb拿数据
        // questionTodo 是否增加数据库异常判断
        pasteInfoForShow.setPasteCode(mongoDbService.selectById(paste.getPastePath()));

        return new PasteInfoVO(200, "sucessful", pasteInfoForShow);
    }
}
