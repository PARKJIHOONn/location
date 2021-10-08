package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.service.BookService;
import kr.ac.kopo.bookstore.service.CustomerService;
import kr.ac.kopo.bookstore.service.OrdersService;
import kr.ac.kopo.bookstore.util.Pager;

@Controller
@RequestMapping("/orders")
public class OrdersController {
   final String path = "orders/";
   
   @Autowired
   OrdersService service;
   
   @Autowired
   BookService bookService;
   
   @Autowired
   CustomerService customerService;
   
   @RequestMapping("/list")
   public String list(Model model) {
      List<Orders> list = service.list();
      
      model.addAttribute("list", list);
      
      return path + "list";
   }
   
   @RequestMapping(value="/add", method=RequestMethod.GET)
   public String add(Model model) {
      
      Pager pager = new Pager();
      pager.setPerPage(999);
      
      List<Customer> customers = customerService.list(pager); // 첫번째 페이지만 가져오도록
      model.addAttribute("customers", customers);
      
      List<Book> books = bookService.list(pager);
      model.addAttribute("books", books);
      return path + "add";
   }
   
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public String add(Orders item) {
      service.add(item);
      
      return "redirect:list";
   }
   
   @RequestMapping("/delete")
   public String delete(int orderid) {
      service.delete(orderid);
      
      return "redirect:list";
   }
   
   @RequestMapping(value="/update", method=RequestMethod.GET)
   public String update(int orderid, Model model) {
      Orders item = service.item(orderid);
      
      Pager pager = new Pager();
      pager.setPerPage(999);
      
      model.addAttribute("item",item);
      
      List<Customer> customers = customerService.list(pager);
      model.addAttribute("customers", customers);
      
      List<Book> books = bookService.list(new Pager());
      model.addAttribute("books", books);
      
      return path + "update";
   }
   
   @RequestMapping(value="/update", method=RequestMethod.POST)
   public String update(Orders item) {
      service.update(item);
      
      return "redirect:list";
   }
   
}