package edu.cqie.entity;

import java.io.Serializable;

/**
 * (EventCategory)实体类
 *
 * @author makejava
 * @since 2024-12-17 16:07:44
 */
public class EventCategory implements Serializable {
    private static final long serialVersionUID = 362002101508773144L;

    private Integer categoryId;

    private Integer userId;

    private String categoryName;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "EventCategory{" +
                "categoryId=" + categoryId +
                ", userId=" + userId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

