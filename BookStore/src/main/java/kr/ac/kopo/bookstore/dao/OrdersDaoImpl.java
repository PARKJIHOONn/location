package kr.ac.kopo.bookstore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookstore.model.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {
   
   @Autowired
   SqlSession sql;

   @Override
   public List<Orders> list() {
      return sql.selectList("orders.list");
   }

   @Override
   public void add(Orders item) {
      sql.insert("orders.add", item);
   }

   @Override
   public void delete(int orderid) {
      sql.delete("orders.delete", orderid);
   }

   @Override
   public Orders item(int orderid) {
      return sql.selectOne("orders.item", orderid);
   }

   @Override
   public void update(Orders item) {
      sql.update("orders.update", item);
   }

}
