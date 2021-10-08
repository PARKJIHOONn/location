package kr.ac.kopo.jogiyo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.jogiyo.model.Category;
import kr.ac.kopo.jogiyo.model.Store;
import kr.ac.kopo.jogiyo.service.CategoryService;
import kr.ac.kopo.jogiyo.service.StoreService;

@RestController
@RequestMapping("/api/category")
public class CategoryApi {
   
   @Autowired
   CategoryService service;
   
   @Autowired
   StoreService storeService;
   
   @GetMapping
   public List<Category> list() {
      return service.list();
   }
   
   @GetMapping("/{categoryId}")
   public List<Store> listStore(@PathVariable int categoryId ) {
      return storeService.list(categoryId);
   }

}