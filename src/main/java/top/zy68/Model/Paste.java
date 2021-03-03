package top.zy68.Model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Paste {
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