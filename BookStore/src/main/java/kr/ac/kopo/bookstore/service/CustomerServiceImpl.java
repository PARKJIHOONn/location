package kr.ac.kopo.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookstore.dao.CustomerDao;
import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.util.Pager;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	@Override
	public List<Customer> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Customer item) {
		dao.add(item);
		
	}

	@Override
	public void delete(int custid) {
		dao.delete(custid);
		
	}

	@Override
	public Customer item(int custid) {
		return dao.item(custid);
	}

	@Override
	public void update(Customer item) {
		dao.update(item);
		
	}

	@Override
	public void delete(List<Integer> customers) {
		for(Integer custid : customers)
			dao.delete(custid);
		
	}

}
