package top.zy68.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.zy68.Model.Paste;
@Mapper
@Component
public interface PasteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paste
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    int deleteByPrimaryKey(String shortLink);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paste
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    int insert(Paste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paste
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    int insertSelective(Paste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paste
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    Paste selectByPrimaryKey(String shortLink);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paste
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    int updateByPrimaryKeySelective(Paste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paste
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    int updateByPrimaryKey(Paste record);
}