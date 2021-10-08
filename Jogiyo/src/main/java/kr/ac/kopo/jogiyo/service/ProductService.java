package kr.ac.kopo.jogiyo.service;

import java.util.List;

import kr.ac.kopo.jogiyo.model.Product;
import kr.ac.kopo.jogiyo.util.Pager;

public interface ProductService {

	List<Product> list(Pager pager);

	void add(Product item);

	Product item(int productId);

	void update(Product item);

	void delete(int productId);

}
