package kr.ac.kopo.jogiyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.jogiyo.dao.ProductDao;
import kr.ac.kopo.jogiyo.dao.ProductImageDao;
import kr.ac.kopo.jogiyo.model.Product;
import kr.ac.kopo.jogiyo.model.ProductImage;
import kr.ac.kopo.jogiyo.util.Pager;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	@Autowired
	ProductImageDao productImageDao;
	
	@Override
	public List<Product> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}
	
	
	@Override
	@Transactional
	public void add(Product item) {
		dao.add(item);
		
		for(ProductImage image : item.getProductImages()) {			
			image.setProductId( item.getProductId() );
			
			productImageDao.add(image);
		}
		
	}

	@Override
	public Product item(int productId) {
		return dao.item(productId);
	}

	@Override
	public void update(Product item) {
		dao.update(item);
	}

	@Override
	@Transactional
	public void delete(int productId) {
		productImageDao.deleteByProductId(productId); 
		
		dao.delete(productId);
	}

}
