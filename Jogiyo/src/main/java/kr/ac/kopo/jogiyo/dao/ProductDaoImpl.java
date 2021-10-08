package kr.ac.kopo.jogiyo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.jogiyo.model.Product;
import kr.ac.kopo.jogiyo.util.Pager;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int total(Pager pager) {
		return sql.selectOne("product.total", pager);
	}

	@Override
	public List<Product> list(Pager pager) {
		return sql.selectList("product.list", pager);
	}

	@Override
	public void add(Product item) {
		sql.insert("product.add", item);
	}

	@Override
	public Product item(int productId) {
		return sql.selectOne("product.item", productId);
	}

	@Override
	public void update(Product item) {
		sql.update("product.update", item);
	}

	@Override
	public void delete(int productId) {
		sql.delete("product.delete", productId);
	}

}
