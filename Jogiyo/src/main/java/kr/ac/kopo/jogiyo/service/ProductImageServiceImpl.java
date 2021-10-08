package kr.ac.kopo.jogiyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.jogiyo.dao.ProductImageDao;
import kr.ac.kopo.jogiyo.model.ProductImage;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	
	@Autowired
	ProductImageDao dao;
	
	@Override
	public void add(ProductImage image) {
		dao.add(image);
	}

	@Override
	public void delete(int productId, int productImageId) {
		dao.delete(productId, productImageId);
	}

}
