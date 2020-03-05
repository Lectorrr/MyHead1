package com.example.myhead.one.entity.resource;

import com.example.myhead.one.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resource_files_type")
public class FilesType extends BaseEntity<String> {

    @Column(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
