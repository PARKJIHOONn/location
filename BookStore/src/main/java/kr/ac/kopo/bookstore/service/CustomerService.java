package kr.ac.kopo.bookstore.service;

import java.util.List;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.util.Pager;

public interface CustomerService {

	List<Customer> list(Pager pager);

	void add(Customer item);

	void delete(int custid);

	Customer item(int custid);

	void update(Customer item);

	void delete(List<Integer> customers);

}
