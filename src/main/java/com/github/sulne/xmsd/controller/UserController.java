package com.github.sulne.xmsd.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private static String name; 
	
	public static boolean verify(String username) {
		return username.equals(name);
	}
	
	@PostMapping("/doLogin")
	public String doLogin (String username, String password) {
		System.out.println(username);
		System.out.println(password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		subject.login(usernamePasswordToken);
		name = username;
		return "1";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "1";
	}
}
