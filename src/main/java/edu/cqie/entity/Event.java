package edu.cqie.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Event)实体类
 *
 * @author makejava
 * @since 2024-12-17 16:05:22
 */
public class Event implements Serializable {
    private static final long serialVersionUID = 253660258758610566L;

    private Integer eventId;

    private Integer userId;

    private Integer categoryId;

    private String eventTitle;

    private Date startDate;

    private Date endDate;

    private String eventContent;

    private Integer eventLevel;

    private Integer isCompleted;

    private String categoryName;


    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public Integer getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(Integer eventLevel) {
        this.eventLevel = eventLevel;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", eventTitle='" + eventTitle + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", eventContent='" + eventContent + '\'' +
                ", eventLevel=" + eventLevel +
                ", isCompleted=" + isCompleted +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

