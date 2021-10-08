package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Orders;

public interface OrdersDao {

   List<Orders> list();

   void add(Orders item);

   void delete(int orderid);

   Orders item(int orderid);

   void update(Orders item);

}