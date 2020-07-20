package com.github.sulne.xmsd.controller;

import java.util.List;

import com.github.sulne.xmsd.web.WebLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sulne.xmsd.pojo.Kb;
import com.github.sulne.xmsd.service.KbService;
@RestController
@RequestMapping("/kb")
public class KbController {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	@Autowired
	private KbService kbService;

	@PostMapping(value = { "/xs/{xs0101id}" })
	public ResponseEntity<String> getXsKb(@PathVariable String xs0101id) {
		logger.debug(test(xs0101id).toString());
		return ResponseEntity.status(HttpStatus.OK).body(xs0101id);
	}

	@GetMapping(value = { "/xskb/{xh}/{xnxq}" })
	public ResponseEntity<List<Kb>> getKb(@PathVariable String xnxq, @PathVariable String xh) {
		return ResponseEntity.status(HttpStatus.OK).body(kbService.getkb(xnxq, xh));
	}

	@PostMapping("/login")
	public String login (String username, String password) {
		System.out.println(username);
		System.out.println(password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		subject.login(usernamePasswordToken);
		return "1";
	}

	public Boolean test(String username) {
		return username.equals(SecurityUtils.getSubject().getPrincipal());
	}
}
