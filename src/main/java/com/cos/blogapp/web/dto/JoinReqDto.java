package com.cos.blogapp.web.dto;

import com.cos.blogapp.domain.user.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinReqDto {

	private String username;
	private String password;
	private String email;
	
	public Users toEntity() {
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		
		
		return user;
	}
	
}
