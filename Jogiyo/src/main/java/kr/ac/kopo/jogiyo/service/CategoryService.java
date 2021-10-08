package kr.ac.kopo.jogiyo.service;

import java.util.List;

import kr.ac.kopo.jogiyo.model.Category;

public interface CategoryService {

	List<Category> list();

	void add(Category item);

	Category item(int categoryId);

	void update(Category item);

	void delete(int categoryId);

}
