package kr.ac.kopo.jogiyo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.jogiyo.model.Member;
import kr.ac.kopo.jogiyo.model.Product;
import kr.ac.kopo.jogiyo.model.ProductImage;
import kr.ac.kopo.jogiyo.service.ProductImageService;
import kr.ac.kopo.jogiyo.service.ProductService;
import kr.ac.kopo.jogiyo.util.Pager;
import kr.ac.kopo.jogiyo.util.Uploader;

@Controller
@RequestMapping("/product")
public class ProductController {
   private final String path = "product/";
   
   @Autowired
   ProductService service;
   
   @Autowired
   ProductImageService productImageService;
   
   @GetMapping("/view/{productId}")
   public String view(@PathVariable int productId, Model model) {
	   Product item = service.item(productId);
	   
	   model.addAttribute("item", item);
	   
	   return path + "view";
   }
   
   
   @GetMapping({"/", "/list"})
   public String list(Model model, Pager pager) {
      List<Product> list = service.list(pager);
      
      model.addAttribute("list",list);
      
      return  path + "list";
   }
   
   @GetMapping("/add")
   public String add() {
   
      return path + "add";
   }
   
   @PostMapping("/add")
   public String add(Product item, List<MultipartFile> files, @SessionAttribute Member member) {
      
	   List<ProductImage> images = new ArrayList<ProductImage>();
      for(MultipartFile file : files) {
    	  String filename = file.getOriginalFilename();

    	  if(Uploader.upload(file)) {
    		  ProductImage image = new ProductImage();
    		  
    		  image.setFilename(filename);    		  
    		  
    		  images.add(image);
    	  }	else
    		  System.out.println("Uploader 처리 실패: " + filename);
      }
      
	  item.setProductImages(images);
	  
	 service.add(item);
      
      return "redirect:list";
   }
   
   @GetMapping("/update/{productId}")
   public String update(@PathVariable int productId, Model model) {
      Product item = service.item(productId);
      
      model.addAttribute("item",item);
      
      return path + "update";
   }
   // 경로에 @PathVariable 걸어줌
   // ex) 3번 상품 수정하고 싶다? 쿼리스트림 둘 필요 x  /product/update/3 하면 update 가능
   
   @PostMapping("/update/{productId}")
   public String update(@PathVariable int productId, Product item) {
      item.setProductId(productId);
      // 사용자 요구사항 분석 ->  서비스 넘기기 전에 사용자 정보 한번에 모아서 넘김
      
      service.update(item);
      
      return "redirect:..";
   }
   @ResponseBody
   @PostMapping("/update/{productId}/image")
   public ProductImage update(@PathVariable int productId, MultipartFile uploadFile) {
	   if(Uploader.upload(uploadFile)) {
		   String filename = uploadFile.getOriginalFilename();
		   
		   ProductImage image = new ProductImage();
		   
		   image.setProductId(productId);
		   image.setFilename(filename);
		   
		   productImageService.add(image);
		   
		   return image;
	   }else
		   return null;
   }
   
   @ResponseBody
   @DeleteMapping("/update/{productId}/{productImageId}")
   public String delete(@PathVariable int productId, @PathVariable int productImageId) {
   			productImageService.delete(productId,productImageId);
   
   			return "OK";
}   
   @RequestMapping("delete/{productId}")
   public String delete(@PathVariable int productId) {
      service.delete(productId);
      
      return "redirect:..";
   }
   
}