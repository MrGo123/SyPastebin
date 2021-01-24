package top.zy68.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.Dao.PasteMapper;
import top.zy68.Model.Paste;
import top.zy68.Service.HandleDataService;

import java.time.LocalDate;
import java.util.Date;

/**
 * @ClassName HandleDataServiceImpl
 * @Description TODO
 * @Author ZY
 * @Date2021/1/24 13:14
 * @Version 1.0
 **/
@Service
public class HandleDataServiceImpl implements HandleDataService {

    @Autowired
    PasteMapper pasteMapper;
    @Autowired
    Paste paste;

    @Override
    public String generateRecord(int saveTime, String pasteCode) {

        //todo1 根据saveTime，通过一个方法确定保存的时间
        // paste.setExpirationTime(saveTime);

        paste.setCreateTime(new Date());

        //todo2 使用md5生成一个shortlink
        // paste.setShortLink();

        //todo3 存储在对象存储中的路径，用一个方法生成。
        // paste.setPastePath();

        paste.setPastePath("hell");
        paste.setShortLink("asdfghk");
        paste.setExpirationTime(3000);

        int flag = pasteMapper.insert(paste);
        if (flag == 1) {
            System.out.println("insert success");
        }

        return "done well";
    }

}
