package com.myboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
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
        System.out.println(bookService.save(book));
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(55);
        book.setName("testupdate");
        book.setType("test testupdate");
        book.setDescription("test testupdate");
        System.out.println(bookService.update(book));
    }
    @Test
    void testDelete(){
        bookService.delete(55);
    }
    @Test
    void testGetAll(){
        bookService.getAll();
    }

    @Test
    void testGetPage(){
        IPage<Book> page = bookService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }
}
