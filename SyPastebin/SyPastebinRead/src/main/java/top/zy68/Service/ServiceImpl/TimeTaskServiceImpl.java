package top.zy68.Service.ServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zy68.Dao.PasteMapper;
import top.zy68.Model.Paste;
import top.zy68.Service.MongoDbService;
import top.zy68.Service.TimeTaskService;

import java.util.List;

/**
 * @ClassName TimeTaskServiceImpl
 * @Description time task to do something
 * @Author Sustart
 * @Date2021/2/25 11:34
 * @Version 1.0
 **/

@Service("TimeTaskService")
public class TimeTaskServiceImpl implements TimeTaskService {

    private static final Logger log = LoggerFactory.getLogger(TimeTaskServiceImpl.class);

    @Autowired
    PasteMapper pasteMapper;

    @Autowired
    MongoDbService mongoDbService;

    @Override
    public void cleanOverdueData() {
        //    提取所有过期的记录
        List<Paste> overdueRecords = pasteMapper.selectOverdueRecords();
        //    根据记录删除mysql中的记录
        //    根据记录删除mongodb中的记录
        for (Paste paste : overdueRecords) {
            pasteMapper.deleteByPrimaryKey(paste.getShortLink());
            mongoDbService.removeById(paste.getPastePath());
            log.info("remove record: " + paste.toString());
        }


    }
}
