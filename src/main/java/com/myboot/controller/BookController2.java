package com.myboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myboot.domain.Book;
import com.myboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController
@RequestMapping("/books")
public class BookController2 {
    //git test =============
    @Autowired
    private IBookService iBookService;
    //http://localhost:8080/books
    @GetMapping
    public List<Book> getAll(){
        return iBookService.list();
    }
    
    @PostMapping
    public boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book){
        return iBookService.modify(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return iBookService.delete(id);
    }
    //http://localhost:8080/books/1
      @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable  int pageSize){
        return iBookService.getPage(currentPage,pageSize, null);
    }

}
