package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.service.BookService;
import kr.ac.kopo.bookstore.util.Pager;

@Controller
@RequestMapping("/book")
public class BookController {
   final String path = "book/";
   
   @Autowired
   BookService service;
   
   @RequestMapping("/dummy")
   public String dummy() {
      service.dummy();
      
      return "redirect:list";
      }
   
   @RequestMapping("/init")
   public String init() {
      service.init();
      
      return "redirect:list";
   }
   
   @RequestMapping("/list")
   public String list(Model model, Pager pager) {
      List<Book> list = service.list(pager);
      
      model.addAttribute("list", list);
      
      return path + "list";
   }
   
   @RequestMapping("/delete")
   public String delete(int bookid) {
      service.delete(bookid);
      
      return "redirect:list";
   }
   
   @RequestMapping(value="/add", method=RequestMethod.GET)
   public String add() {
      return path + "add";
   }
   
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public String add(Book item) {
      service.add(item);
      
      return "redirect:list";
   }
   
   @RequestMapping(value="/update", method=RequestMethod.GET)
   public String update(int bookid, Model model) {
      Book item = service.item(bookid);
      
      model.addAttribute("item", item);
      
      return path + "update";
   }
   
   @RequestMapping(value="/update", method=RequestMethod.POST)
   public String update(Book item) {
      service.update(item);
      
      return "redirect:list";
   }
   
}
