package com.example.myhead.one.service.library;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dao.library.CategoryDao;
import com.example.myhead.one.entity.library.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category> {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 查找类型是否存在
     * @param type 书籍类型
     */
    public Category findByType(String type) {
        Category category = categoryDao.findByType(type);
        return  category;
    }
}
