package kr.ac.kopo.bookstore.service;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.util.Pager;

public interface BookService {

	List<Book> list(Pager pager);

	void delete(int bookid);

	void add(Book item);

	Book item(int bookid);

	void update(Book item);

	void dummy();

	void init();

	void delete(List<Integer> books);

}
