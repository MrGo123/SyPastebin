package top.zy68.Model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Paste {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paste.short_link
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    private String shortLink;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paste.expiration_time
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    private Integer expirationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paste.create_time
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paste.paste_path
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    private String pastePath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paste.short_link
     *
     * @return the value of paste.short_link
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public String getShortLink() {
        return shortLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paste.short_link
     *
     * @param shortLink the value for paste.short_link
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paste.expiration_time
     *
     * @return the value of paste.expiration_time
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public Integer getExpirationTime() {
        return expirationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paste.expiration_time
     *
     * @param expirationTime the value for paste.expiration_time
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paste.create_time
     *
     * @return the value of paste.create_time
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paste.create_time
     *
     * @param createTime the value for paste.create_time
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paste.paste_path
     *
     * @return the value of paste.paste_path
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public String getPastePath() {
        return pastePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paste.paste_path
     *
     * @param pastePath the value for paste.paste_path
     *
     * @mbg.generated Sun Jan 24 13:39:28 CST 2021
     */
    public void setPastePath(String pastePath) {
        this.pastePath = pastePath;
    }

    @Override
    public String toString() {
        return "Paste{" +
                "shortLink='" + shortLink + '\'' +
                ", expirationTime=" + expirationTime +
                ", createTime=" + createTime +
                ", pastePath='" + pastePath + '\'' +
                '}';
    }
}