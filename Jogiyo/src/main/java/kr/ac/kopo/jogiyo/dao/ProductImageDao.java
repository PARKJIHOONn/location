package kr.ac.kopo.jogiyo.dao;

import kr.ac.kopo.jogiyo.model.ProductImage;

public interface ProductImageDao {

	void add(ProductImage image);

	void deleteByProductId(int productId);

	void delete(int productId, int productImageId);

}
