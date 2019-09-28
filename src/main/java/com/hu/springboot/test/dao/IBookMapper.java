package com.hu.springboot.test.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface IBookMapper {
    public int insert(Book book);//插入数据
    public List<Book> find(int bookId);//查找数据
    public int delete(int bookId); //删除数据
}
