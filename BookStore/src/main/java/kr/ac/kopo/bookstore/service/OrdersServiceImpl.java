package kr.ac.kopo.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookstore.dao.OrdersDao;
import kr.ac.kopo.bookstore.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {
   
   @Autowired
   OrdersDao dao;

   @Override
   public List<Orders> list() {
      return dao.list();
   }

   @Override
   public void add(Orders item) {
      dao.add(item);
   }

   @Override
   public void delete(int orderid) {
      dao.delete(orderid);
   }

   @Override
   public Orders item(int orderid) {
      return dao.item(orderid);
   }

   @Override
   public void update(Orders item) {
      dao.update(item);
   }

}
