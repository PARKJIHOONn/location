package kr.ac.kopo.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookstore.dao.BookDao;
import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.util.Pager;

@Service
public class BookServiceImpl implements BookService {
   
   @Autowired
   @Qualifier("BookDaoOracle")
   BookDao dao;
   
   @Override
   public List<Book> list(Pager pager) {
	   int total = dao.total(pager);
	   
	   pager.setTotal((float) total);
	   
      return dao.list(pager);
   }

   @Override
   public void delete(int bookid) {
      dao.delete(bookid);
   }

   @Override
   public void add(Book item) {
      dao.add(item);
      
   }

   @Override
   public Book item(int bookid) {
      return dao.item(bookid);
   }

   @Override
   public void update(Book item) {
      dao.update(item);
   }

   @Override
   public void dummy() {
      for(int index=1; index < 100; index++) {
         Book item = new Book();
         
         item.setBookname("도서명" + index);
         item.setPublisher("출판사" + index);
         item.setPrice(1000 * index);
         
         dao.add(item);
      }
      
   }

   @Override
   public void init() {
	   Pager pager = new Pager();
	   
	   List<Book> list = dao.list(pager);
	   
	   while(list.size() > 0) {
		   for(Book item : list)
			   dao.delete(item.getBookid());
		   
		   list = dao.list(pager);  
	   } 
   }

@Override
public void delete(List<Integer> books) {
	for(Integer bookid : books)
		dao.delete(bookid);
	
}
}