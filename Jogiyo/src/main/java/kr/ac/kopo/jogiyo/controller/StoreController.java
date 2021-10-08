package kr.ac.kopo.jogiyo.controller;

import java.util.List;

import org.aspectj.lang.annotation.DeclareMixin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.jogiyo.model.Category;
import kr.ac.kopo.jogiyo.model.Member;
import kr.ac.kopo.jogiyo.model.Store;
import kr.ac.kopo.jogiyo.service.CategoryService;
import kr.ac.kopo.jogiyo.service.MemberService;
import kr.ac.kopo.jogiyo.service.StoreService;
import kr.ac.kopo.jogiyo.util.Pager;

@Controller
@RequestMapping("/store")
public class StoreController {
   private final String path = "store/";
   
   @Autowired
   StoreService service;
   
   @Autowired
   MemberService memberService;
   
   @Autowired
   CategoryService categoryService;
      
   
   @RequestMapping({"", "/", "/list"})
   public String list(Pager pager, Model model) {
      List<Store> list = service.list(pager);
      
      model.addAttribute("list", list);
      
      return path + "list";
   }
   
   @GetMapping("/add")
   public String add(Model model) {
      List<Member> members = memberService.list();
      model.addAttribute("members", members);
      
      List<Category> categorys = categoryService.list();
      model.addAttribute("categorys", categorys);
      
      return path + "add";
   }
   
   @PostMapping("/add")
   public String add(Store item) {
      service.add(item);
      
      return "redirect:list";
   }
   
   @GetMapping("/update")
   public String update(int storeId, Model model) {
      Store item = service.item(storeId);
      model.addAttribute("item", item);
      
      List<Member> members = memberService.list();
      model.addAttribute("members", members);
      
      List<Category> categorys = categoryService.list();
       model.addAttribute("categorys", categorys);

      
      return path + "update";
   }
   
   @PostMapping("/update")
   public String update(Store item) {
      service.update(item);
      
      return "redirect:list";
   }
   
   @RequestMapping("/delete")
   public String delete(int storeId) {
      service.delete(storeId);
      
      return "redirect:list";
   }

}