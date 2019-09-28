package com.hu.springboot.test.controller;

import com.hu.springboot.test.dao.Book;
import com.hu.springboot.test.service.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SpringBoot Study Test")
@RestController
@RequestMapping(value = "/controller")
public class TestController {
    @Autowired
    IBookService ibookService;

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @ApiOperation(value = "test", notes = "test")
   @GetMapping(value = "/test")
    public String test() {
        return "test is success;";
    }

    @ApiOperation(value = "book", notes = "book")
   @GetMapping("/book")
    public String book(){
       return "BookName is "+bookName+", BookAuthor -is "+bookAuthor;
   }

    /**
     * 通过ID查询数据
     * unless：true表示不保存到缓存，与condition相反
     * @param bookId
     * @return
     */
    @ApiOperation(value = "findbook", notes = "使用xml查找数据库数据")
    @Cacheable(cacheNames = {"findbook"},value="findbook",key = "#bookId")
    @GetMapping("/findbook/{bookId}")
    public List<Book> findbook(@PathVariable(value = "bookId") int bookId){
       return ibookService.find(bookId);
    }

    /**
     * 使用@CachePut：在新增对象时就放入缓存中，一般不建议这么做，因为会造成缓存过多，也没有必要每条新增数据都放入缓存
     * @param book
     */
    @ApiOperation(value = "insertbook", notes = "使用xml新增数据库数据")
    @PostMapping("/insertbook")
    public boolean insertbook(@RequestBody Book book){
        return ibookService.insert(book);
    }

    /**
     * 使用@CacheEvict消除缓存，在每次对数据进行删除时，就清除缓存。
     * @param bookId
     */
    @CacheEvict(key = "#bookId")
    @ApiOperation(value = "delete", notes = "使用xml删除数据库数据")
    @DeleteMapping("/delete/{bookId}")
    public boolean delete(@PathVariable(value = "bookId") int bookId){
       return  ibookService.delete(bookId);
    }

}
