package kr.ac.kopo.jogiyo.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.jogiyo.model.ProductImage;

@Repository
public class ProductImageDaoImpl implements ProductImageDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void add(ProductImage item) {
		sql.insert("product_image.add", item);
	}
	
	@Override
	public void deleteByProductId(int productId) {
		sql.delete("product_image.deleteByProductId", productId);
	}

	@Override
	public void delete(int productId, int productImageId) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("productId", productId);
		map.put("productImageId", productImageId);
		
		
		sql.delete("product_image.delete", map);
	}
	

}
