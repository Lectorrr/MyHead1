package com.example.myhead.one.dto.library;

import com.example.myhead.one.base.BaseDTO;

/**
 * 图书信息
 */
public class BookInfoDTO extends BaseDTO<String> {

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 作者姓名
     */
    private String author;

    /**
     * 出版社名称
     */
    private String publish;

    /**
     * 封面图片
     */
    private String coverImg;

    /**
     * 书籍简介
     */
    private String description;

    /**
     * 书籍分类
     */
    private CategoryDTO category;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
