package kr.ac.kopo.bookstore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.service.BookService;
import kr.ac.kopo.bookstore.util.Pager;

@RestController
@RequestMapping("/api/book")
public class BookApiController {

   
   @Autowired
   BookService service;
   
   @GetMapping
   public HashMap<String, Object> list(Pager pager){
      
      List<Book> list = service.list(pager);
      
      
      HashMap<String, Object> map = new HashMap<String, Object>();
      
      map.put("list", list);
      map.put("pager", pager);
      
      return map;
      
   }
   
   @PostMapping
   public Book add(@RequestBody Book item) {
      service.add(item);
      
      return item;
      
   }
   
   @PutMapping
   public Book update(@RequestBody Book item) {
      service.update(item);
      
      return item;
   }
   
   @DeleteMapping("/{bookid}")
   public Integer depete(@PathVariable int bookid) {
      service.delete(bookid);
      
      return bookid;
   }
   
   @DeleteMapping
   public List<Integer> delete(@RequestBody List<Integer> books){
      service.delete(books);
      
      return books;
   }
   
}