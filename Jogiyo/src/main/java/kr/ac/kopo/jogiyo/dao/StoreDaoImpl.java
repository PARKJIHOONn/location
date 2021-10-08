package kr.ac.kopo.jogiyo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.jogiyo.model.Store;
import kr.ac.kopo.jogiyo.util.Pager;

@Repository
public class StoreDaoImpl implements StoreDao {
   
   @Autowired
   SqlSession sql;

   @Override
   public int total(Pager pager) {
      return sql.selectOne("store.total", pager);
   }

   @Override
   public List<Store> list(Pager pager) {
      return sql.selectList("store.list", pager);
   }

   @Override
   public void add(Store item) {
      sql.insert("store.add", item);
   }

   @Override
   public Store item(int storeId) {
      return sql.selectOne("store.item", storeId);
   }

   @Override
   public void update(Store item) {
      sql.update("store.update", item);
   }

   @Override
   public void delete(int storeId) {
      sql.delete("store.delete", storeId);
   }

@Override
public List<Store> list(int categoryId) {
	return sql.selectList("store.listByCategory", categoryId);
}

}