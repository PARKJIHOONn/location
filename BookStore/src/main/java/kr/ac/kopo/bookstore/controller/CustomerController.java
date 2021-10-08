package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.service.CustomerService;
import kr.ac.kopo.bookstore.util.Pager;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	final String path = "customer/";
	
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Customer> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";  //customer/list
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return path + "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Customer item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(int custid) {
		service.delete(custid);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(int custid, Model model) {
		Customer item = service.item(custid);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Customer item) {
		service.update(item);
		
		return "redirect:list";
	}
}
