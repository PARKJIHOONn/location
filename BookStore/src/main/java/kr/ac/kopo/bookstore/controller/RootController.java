package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.service.BookService;

@Controller
public class RootController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	

}	
