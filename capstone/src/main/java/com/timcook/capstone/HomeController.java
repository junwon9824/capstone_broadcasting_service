package com.timcook.capstone;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/login/success")
	public String success() {
		return "로그인이 성공적으로 완료되었습니다.";
	}
	
	@GetMapping("/login/fail")
	public String fail() {
		return "로그인에 실패했습니다.";
	}
	
	@GetMapping("/logout/success")
	public String logout() {
		return "로그아웃 되었습니다.";
	}
}
