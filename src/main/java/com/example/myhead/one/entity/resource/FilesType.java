package com.example.myhead.one.entity.resource;

import com.example.myhead.one.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resource_files_type")
public class FilesType extends BaseEntity<String> {
}
