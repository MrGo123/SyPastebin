package top.zy68.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zy68.model.Paste;

import java.util.List;

@Mapper
@Repository
public interface PasteMapper {
    int deleteByPrimaryKey(String shortLink);

    int insert(Paste record);

    int insertSelective(Paste record);

    Paste selectByPrimaryKey(String shortLink);

    int updateByPrimaryKeySelective(Paste record);

    int updateByPrimaryKey(Paste record);

    List<Paste> selectOverdueRecords();
}