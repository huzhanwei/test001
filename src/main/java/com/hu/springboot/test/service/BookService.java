package com.hu.springboot.test.service;

import com.hu.springboot.test.dao.Book;
import com.hu.springboot.test.dao.IBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookMapper iBookMapper;

    @Cacheable(key = "#p0")
    @Override
    public List<Book> find(int bookId) {
        System.out.println(" call findById method ");
        return iBookMapper.find(bookId);
    }

    @Override
    public Boolean insert(Book book){
        int i = 0;
        if(null!=book&&book.getBookId()!=0){
          i = iBookMapper.insert(book);
        }

        return i==0? false : true;
    }

    @Override
    public Boolean delete(int bookId){
        int i=0;
        if(bookId != 0){
           i= iBookMapper.delete(bookId);
        }
        return i==0? false : true;
    }
}
