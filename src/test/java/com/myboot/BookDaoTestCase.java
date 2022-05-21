package com.myboot;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myboot.dao.BookDao;
import com.myboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
        Book book = new Book();

    }

    @Test
    void testSave(){
        Book book = new Book();

        //book.("sad");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(53);
        book.setType("测试数据bbbbbbnnnnnbbbb");
        book.setName("测试数据1vvvav23");
        book.setDescription("测试数据avavav123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(16);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }
    @Test
    void testGetPage(){
        IPage page = new Page(1,5);//依赖config拦截器
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

    @Test
    void testGetBy(){
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(Book::getName,"Spring");
        bookDao.selectList(qw);
    }

}
