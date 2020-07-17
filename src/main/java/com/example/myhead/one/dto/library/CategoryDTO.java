package com.example.myhead.one.dto.library;

import com.example.myhead.one.base.BaseDTO;
import com.example.myhead.one.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 图书类型分类
 */
public class CategoryDTO extends BaseDTO<String> {

    /**
     * 书籍类型
     */
    private Integer typeCode = 0;

    /**
     * 类型名称
     */
    private String type;

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
