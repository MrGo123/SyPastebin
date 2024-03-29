package top.zy68.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Sustart
 */
@Component
@ToString
public class Paste implements Serializable {
    private static final long serialVersionUID = -1L;

    private String shortLink;

    private Date expirationTime;

    private Date createTime;

    private String pastePath;

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPastePath() {
        return pastePath;
    }

    public void setPastePath(String pastePath) {
        this.pastePath = pastePath;
    }
}