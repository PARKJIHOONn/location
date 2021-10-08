package kr.ac.kopo.jogiyo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.jogiyo.model.Category;

@Controller
public class UploadController {
   ArrayList<Category> list;
   
   final String path = "d://upload/";
   
   public UploadController() {
      list = new ArrayList<Category>();
   }
   
   @RequestMapping(value = "/upload", method=RequestMethod.GET)
      public String upload(Model model) {
      model.addAttribute("list", list);
      
         return "upload";
   }
   
   @ResponseBody
   @RequestMapping(value="/upload_ajax", method=RequestMethod.POST, produces = "text/plain; charset=UTF-8")
   public String upload_ajax(Category item) {
      upload(item);
      
      return item.getImage();
   }
   
   @RequestMapping(value = "/upload", method=RequestMethod.POST)
   public String upload(Category item) {
      MultipartFile file = item.getUploadFile();
      
      if(file.getSize() > 1) {
         String filename = file.getOriginalFilename();
         
         System.out.println( filename );
         
         item.setImage(filename);
         
         try {
         file.transferTo( new File(path + filename) );
         
          list.add(item);
      } catch (Exception e) {
         e.printStackTrace();
      }
      }
      
      return "redirect:upload";
   }
}
   