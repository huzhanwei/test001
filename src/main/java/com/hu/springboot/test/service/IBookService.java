package com.hu.springboot.test.service;

import com.hu.springboot.test.dao.Book;
import java.util.List;

public interface IBookService {
    public List<Book> find(int bookId);
    public Boolean insert(Book book);//插入数据
    public Boolean delete(int bookId);//删除数据
}
