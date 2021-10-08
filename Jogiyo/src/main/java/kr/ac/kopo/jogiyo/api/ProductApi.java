package kr.ac.kopo.jogiyo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.jogiyo.model.Product;
import kr.ac.kopo.jogiyo.model.ProductImage;
import kr.ac.kopo.jogiyo.service.ProductService;
import kr.ac.kopo.jogiyo.util.Pager;

@RestController
@RequestMapping("/api/product")
public class ProductApi {
   
   @Autowired
   ProductService service;
   
   @GetMapping
   public List<Product> list() {
      return service.list(new Pager());
   }
   
   @PostMapping
   public Product add(@RequestBody Product item) {
      List<ProductImage> images = new ArrayList<ProductImage>();
      
      item.setProductImages(images);
      
      service.add(item);
      
      return item;
   }
   
   @DeleteMapping("/{productId}")
   public int delete(@PathVariable int productId) {
      service.delete(productId);
      
      return productId;
   }
   
   @PutMapping
   public Product update(@RequestBody Product item) {
	   service.update(item);
	   
	   return item;
   }
   
   @GetMapping("/{productId}")
   public Product item(@PathVariable int productId) {
	   return service.item(productId);
   }
   
}