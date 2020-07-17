package com.example.myhead.one.service.library;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dao.library.BookInfoDao;
import com.example.myhead.one.dto.library.BookInfoDTO;
import com.example.myhead.one.entity.library.BookInfo;
import com.example.myhead.one.entity.library.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoService extends BaseService<BookInfo, BookInfoDTO, String> {

    @Autowired
    private BookInfoDao bookInfoDao;

    @Override
    public BookInfoDTO toDTO(BookInfo entity) {
        BookInfoDTO result = new BookInfoDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, result);
        }
        return result;
    }

    @Override
    public BookInfo toEntity(BookInfoDTO dto) {
        BookInfo result = new BookInfo();
        if (dto != null) {
            BeanUtils.copyProperties(dto, result);
        }
        return result;
    }

    public List<BookInfo> findListByBookName(String bookName) {
        return bookInfoDao.findByBookName(bookName);
    }

    public List<BookInfo> findByPublish(String publish) {
        return bookInfoDao.findByPublish(publish);
    }

    public List<BookInfo> findByAuthor(String author) {
        return bookInfoDao.findByAuthor(author);
    }

    public List<BookInfo> findAllByCategory(Category category) {
        return bookInfoDao.findAllByCategory(category);
    }

    public List<BookInfo> findAllByBookNameLikeOrAuthorLike(String bookName, String author) {
        return bookInfoDao.findAllByBookNameLikeOrAuthorLike(bookName, author);
    }
}
