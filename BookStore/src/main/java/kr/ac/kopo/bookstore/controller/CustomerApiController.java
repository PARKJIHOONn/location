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

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.service.CustomerService;
import kr.ac.kopo.bookstore.util.Pager;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {
	
	@Autowired
	 CustomerService service;
	
	@GetMapping
	public HashMap<String, Object> list(Pager pager) {
		List<Customer> list = service.list(pager);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list",list);
		map.put("pager",pager);
		
		return map;
	}
	
	@PostMapping
	public Customer add(@RequestBody Customer item) {
		service.add(item);
		
		return item;
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer item) {
		service.update(item);
		
		return item;
	}
	
	@DeleteMapping("/{custid}")
	public Integer delete(@PathVariable	int custid) {
		service.delete(custid);
		
		return custid;
	}
	
	@DeleteMapping
	public List<Integer> delete(@RequestBody List<Integer> customers) {
		service.delete(customers);
		
		return customers;
	}
}
