package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	/*
	 * login bean 필요할 때 test 하는방법// eclipse console 창으로 확인
	 * 
	 * @Autowired private UserBean loginUserBean; //@Resource(name =
	 * "loginUserBean") -> 실행 안되면 고치기
	 */	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//System.out.println(loginUserBean);
		
		//System.out.println(request.getServletContext().getRealPath("/"));
		
		
		return "redirect:/main";
	}
}

