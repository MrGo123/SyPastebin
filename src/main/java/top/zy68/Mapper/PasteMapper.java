package top.zy68.Mapper;


import org.springframework.stereotype.Repository;
import top.zy68.Model.Paste;

@Repository
public interface PasteMapper {

    /**
     * Create a record into mysql.
     * @param paste
     */
    void createData(Paste paste);

    /**
     * Read a record from the database by shortLink given.
     * @param shortLink
     * @return
     */
    Paste readPaste(String shortLink);

    /**
     * Find that whether the record is existed.
     * @param shortLink
     * @return
     */
    int findExist(String shortLink);
}
