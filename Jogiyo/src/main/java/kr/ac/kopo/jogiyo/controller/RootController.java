package kr.ac.kopo.jogiyo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.jogiyo.model.Member;
import kr.ac.kopo.jogiyo.service.CategoryService;
import kr.ac.kopo.jogiyo.service.MemberService;

@Controller
public class RootController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/web")
	public String web() {
		return "redirect:/html/app.html";
	}
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@ResponseBody
	@RequestMapping("/checkId")
	public String checkId(String id) {
		if(service.checkId(id))
			return "OK";
		else
			return "FAIL";
	}
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	@PostMapping("/signup")
	public String signup(Member item) {
		service.add(item);
		  
		return "redirect:."; //.은 현재 페이지
		
	}
	//session : 저장해놓을 떄 사용(장바구니)
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(Member item, HttpSession session) {
		Member member = service.login(item.getId());
		
		
		if(member != null) {
			String id = member.getId();
			String passwd = member.getPasswd();
			
			if(id.equals(item.getId()) && passwd.equals(item.getPasswd()) ) {
				session.setAttribute("member", member);
				
				return "redirect:.";
			}
				
				return "redirect:login";
			}
			
		return "redirect:login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
		
	}
}
