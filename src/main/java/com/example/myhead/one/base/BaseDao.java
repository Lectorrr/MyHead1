package com.example.myhead.one.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseDao<E extends BaseEntity, T extends Serializable> extends JpaRepository<E, T>, JpaSpecificationExecutor<E> {

}
