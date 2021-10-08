package kr.ac.kopo.jogiyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.jogiyo.dao.StoreDao;
import kr.ac.kopo.jogiyo.model.Store;
import kr.ac.kopo.jogiyo.util.Pager;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreDao dao;
	
	@Override
	public List<Store> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Store item) {
		dao.add(item);

	}

	@Override
	public Store item(int storeId) {
		return dao.item(storeId);
	}

	@Override
	public void update(Store item) {
		dao.update(item);

	}

	@Override
	public void delete(int storeId) {
		dao.delete(storeId);

	}

	@Override
	public List<Store> list(int categoryId) {
		return dao.list(categoryId);
	}

}
