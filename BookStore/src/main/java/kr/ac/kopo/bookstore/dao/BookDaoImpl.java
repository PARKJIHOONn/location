package kr.ac.kopo.bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.util.Pager;

@Repository("BookDaoImpl")
public class BookDaoImpl implements BookDao {

	List<Book> list;
	
	public BookDaoImpl() {
		if(list == null)
			list = new ArrayList<Book>();
		
		Book item = new Book();
		item.setBookid(1);
		item.setBookname("자바의 정석");
		item.setPublisher("폴리텍");
		item.setPrice(2500);
		list.add(item);
		
		item = new Book();
		item.setBookid(2);
		item.setBookname("c++ 완성");
		item.setPublisher("한빛미디어");
		item.setPrice(4500);
		list.add(item);
		
		item = new Book();
		item.setBookid(3);
		item.setBookname("테이터베이스 개론");
		item.setPublisher("생능출판사");
		item.setPrice(5500);
		list.add(item);

	}
	
	@Override
	public List<Book> list(Pager pager) {
		return list;
	}

	@Override
	public void delete(int bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid) {
				list.remove(item);
				return;
			}
			
		}
	}

	@Override
	public void add(Book item) {
		list.add(item);
		
	}

	@Override
	public Book item(int bookid) {
		for(Book item : list)
			if(item.getBookid() == bookid)
				return item;
		
		return null;
	}

	@Override
	public void update(Book item) {
		for(Book book : list)
			if(item.getBookid() == book.getBookid()) {
				book.setBookname(item.getBookname());
				book.setPublisher(item.getPublisher());
				book.setPrice(item.getPrice());
				return;
			}
	}

	@Override
	public int total(Pager pager) {
		return list.size();
	}

}
