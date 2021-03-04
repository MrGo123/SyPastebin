package top.zy68.Dao;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zy68.Model.Paste;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PasteMapperTest {

    @Autowired
    PasteMapper pasteMapper;

    private final static Logger log = LoggerFactory.getLogger(PasteMapperTest.class);
    // @Test
    void deleteByPrimaryKey() {
    }

    // @Test
    void insert() {
    }

    // @Test
    void insertSelective() {
    }

    @Test
    void selectOverdueRecords() {
        List<Paste> records = pasteMapper.selectOverdueRecords();
        for(Paste paste : records){
            log.info(paste.toString());
        }
    }

    // @Test
    void selectByPrimaryKey() {
        Paste paste = pasteMapper.selectByPrimaryKey("UUUUUUU");
        if(paste == null){
            log.info("it is null");
        }else{
            log.info(paste.toString());
        }

    }

    // @Test
    void updateByPrimaryKeySelective() {
    }

    // @Test
    void updateByPrimaryKey() {
    }
}