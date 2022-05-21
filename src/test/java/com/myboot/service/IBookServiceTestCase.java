package com.myboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTestCase {
    @Autowired
    private IBookService iBookService;

    @Test
    void testGetById(){
        System.out.println(iBookService.getById(1));
    }

    /*   boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    */
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("testsave");
        book.setType("test save");
        book.setDescription("test aaaaa");
        System.out.println(iBookService.save(book));
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(55);
        book.setName("testupdate");
        book.setType("test testupdate");
        book.setDescription("test testupdate");
        System.out.println(iBookService.updateById(book));
    }
    @Test
    void testDelete(){
        iBookService.removeById(55);
    }
    @Test
    void testGetAll(){
        iBookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        iBookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }
}
