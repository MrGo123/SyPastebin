package top.zy68.Model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

/**
 * @ClassName PasteCode
 * @Description paste in mongodb
 * @Author Sustart
 * @Date2021/1/28 15:16
 * @Version 1.0
 **/

public class PasteCode {
    @Id
    private String id;

    private String pasteCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PasteCode(String pasteCode) {
        this.pasteCode = pasteCode;
    }

    public PasteCode() {
    }

    public String getPasteCode() {
        return pasteCode;
    }

    public void setPasteCode(String pasteCode) {
        this.pasteCode = pasteCode;
    }
}
