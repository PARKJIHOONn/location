package kr.ac.kopo.jogiyo.dao;

import java.util.List;

import kr.ac.kopo.jogiyo.model.Store;
import kr.ac.kopo.jogiyo.util.Pager;

public interface StoreDao {

   int total(Pager pager);

   List<Store> list(Pager pager);

   void add(Store item);

   Store item(int storeId);

   void update(Store item);

   void delete(int storeId);

List<Store> list(int categoryId);

}