package com.example.myhead.one.service.library;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dao.library.CategoryDao;
import com.example.myhead.one.dto.library.CategoryDTO;
import com.example.myhead.one.entity.library.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, CategoryDTO, String> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryDTO toDTO(Category entity) {
        CategoryDTO result = new CategoryDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, result);
        }
        return result;
    }

    @Override
    public Category toEntity(CategoryDTO dto) {
        Category result = new Category();
        if (dto != null) {
            BeanUtils.copyProperties(dto, result);
        }
        return result;
    }

    /**
     * 查找类型是否存在
     *
     * @param type 书籍类型
     */
    public Category findByType(String type) {
        Category category = categoryDao.findByType(type);
        return category;
    }
}
