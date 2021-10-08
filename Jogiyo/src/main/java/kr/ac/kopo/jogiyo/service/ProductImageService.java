package kr.ac.kopo.jogiyo.service;

import kr.ac.kopo.jogiyo.model.ProductImage;

public interface ProductImageService {

	void add(ProductImage image);

	void delete(int productId, int productImageId);

}
