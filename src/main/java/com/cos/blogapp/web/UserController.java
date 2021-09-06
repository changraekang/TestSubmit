package com.cos.blogapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp.domain.user.Users;
import com.cos.blogapp.domain.user.UserRepository;
import com.cos.blogapp.web.dto.JoinReqDto;
import com.cos.blogapp.web.dto.LoginReqDto;

@Controller
public class UserController {

		private UserRepository userRepository;
		private HttpSession	session;
		
		//DI주입
		public UserController(UserRepository userRepository, HttpSession session ) {
			this.userRepository = userRepository;
			this.session		= session;
			
		}
		
		@GetMapping("/home")
		public String home() {
			
			return "/user/loginForm";
		}
		@GetMapping("/joinForm")
		public String joinForm() {
			
			//String login ="/user/login";
			
			return "/user/joinForm" ;
		}
		
		
		@PostMapping("/login")
		public String login(LoginReqDto dto) {
			
			System.out.println(dto.getUsername());
			System.out.println(dto.getPassword());
			
			Users userEntitiy = userRepository.mLogin(dto.getUsername(), dto.getPassword()); 
			
			if(userEntitiy == null) {
				return "redirect:/loginForm";
			}else {
				session.setAttribute("principal", userEntitiy);
				return "redirect:/home";
			}
			
		}
		@PostMapping("/join")
		public String join(JoinReqDto dto) {
			
			
			userRepository.save(dto.toEntity());
			return "redirect:/loginForm";
		}
	
	
}
