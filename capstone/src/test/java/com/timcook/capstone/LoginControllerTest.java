package com.timcook.capstone;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

//@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class LoginControllerTest {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	MockMvc mockMvc;
	@Autowired
	EntityManager em;
	
	@Test
	@DisplayName("React 헤더 값 추출 테스트")
	void react_header_test() throws Exception {
		
		MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
		info.add("email", "user1");
		info.add("password", "password");

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
									.contentType(MediaType.APPLICATION_FORM_URLENCODED)
									.params(info)).andReturn();
		
		String headerValue = mvcResult.getResponse().getCookies().toString();
		
		log.info("{}",headerValue);
		
	}

}
