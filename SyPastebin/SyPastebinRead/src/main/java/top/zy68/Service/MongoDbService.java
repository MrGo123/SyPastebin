package top.zy68.Service;

public interface MongoDbService {
    /**
     * insert or update a document and return the id
     * @param pasteCode
     * @return
     */
    String insertDocument(String pasteCode);

    /**
     * select the code by id
     * @param id
     * @return
     */
    String selectById(String id);

    /**
     * remove a document by id, return the document numbers which were removed.
     * @param id
     * @return
     */
    int removeById(String id);
}
