package kr.ac.kopo.jogiyo.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.jogiyo.model.Category;
import kr.ac.kopo.jogiyo.service.CategoryService;
import kr.ac.kopo.jogiyo.util.Uploader;

@Controller
@RequestMapping("/category")
public class CategoryController {
   final String path = "category/";
   

   @Autowired
   CategoryService service;

   @RequestMapping({ "", "/", "/list" }) // /, /list 둘 다 처리하겠다
   public String list(Model model) {
      List<Category> list = service.list();

      model.addAttribute("list", list);

      return path + "list";
   }

   @RequestMapping(value = "/add", method = RequestMethod.GET)
   public String add() {
      return path + "add";
   }

   @RequestMapping(value = "/add", method = RequestMethod.POST)
   public String add(Category item) {
      if(Uploader.upload(item.getUploadFile())) {
    	  item.setImage(item.getUploadFile().getOriginalFilename()  );
    	  service.add(item);
      }

      return "redirect:list";
   }

   @RequestMapping(value = "/update", method = RequestMethod.GET)
   public String update(int categoryId, Model model) {
      Category item = service.item(categoryId);

      model.addAttribute("item", item);

      return path + "update";
   }

   @RequestMapping(value = "/update", method = RequestMethod.POST)
   public String update(Category item) {
      if(Uploader.upload(item.getUploadFile()))
    	  item.setImage(item.getUploadFile().getOriginalFilename() );
          service.update(item);
      
      return "redirect:list";
   }



@RequestMapping("/delete")
   public String delete(int categoryId) {
      service.delete(categoryId);

      return "redirect:list";
   }

}