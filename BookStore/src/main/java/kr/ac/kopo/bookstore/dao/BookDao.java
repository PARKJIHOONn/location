package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.util.Pager;

public interface BookDao {

	List<Book> list(Pager pager);

	void delete(int bookid);

	void add(Book item);

	Book item(int bookid);

	void update(Book item);

	int total(Pager pager);

}
