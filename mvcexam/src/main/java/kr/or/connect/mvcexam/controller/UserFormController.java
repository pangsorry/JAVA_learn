package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserFormController {
	
//	@GetMapping(path="/userform")
//	public String plusform() {
//		return "userForm";
//	}
	
	//상단의 주석과 같은 기능
	@RequestMapping(path="/userform", method=RequestMethod.GET)
	public String userform() {
		return "userForm";
	}
	
	
//	@PostMapping(path="/regist")
//	public String plus(@RequestParam(name="username", required=true) String name,
//			@RequestParam(name="useremail", required=true) String email,
//			@RequestParam(name="userage", required=true)int age,
//			ModelMap modelMap){
	
	@RequestMapping(path="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) {
		
		System.out.println(user);
		
		return "main";		
	}
	
}
