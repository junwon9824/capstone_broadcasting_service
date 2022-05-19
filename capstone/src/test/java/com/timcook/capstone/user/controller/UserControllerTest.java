package com.timcook.capstone.user.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	MockMvc mockMvc;
	@Autowired
	EntityManager em;
	
	@Test
	@DisplayName("유저 등록 중복 테스트")
	void save_test() throws Exception {

		MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
		info.add("email", "test_email");
		
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					MvcResult mvcResult;
					try {
						mockMvc.perform(MockMvcRequestBuilders
								.post("/api/users")
								.params(info)
								.contentType(MediaType.MULTIPART_FORM_DATA));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
}
