package com.timcook.capstone.user.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.admin.dto.AdminResponse;
import com.timcook.capstone.admin.repository.AdminRepository;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.user.dto.UserCreateRequest;
import com.timcook.capstone.user.dto.UserResponse;
import com.timcook.capstone.user.repository.UserRepository;
import com.timcook.capstone.village.dto.VillageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;
	private final AdminRepository adminRepository;
	
	public List<UserResponse> findAll(){
		return userRepository.findAll().stream()
				.filter(user -> user.getRole().equals(Role.ROLE_USER))
				.map(user -> UserResponse.from(user))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public UserResponse register(UserCreateRequest userCreateRequest) {
		User user = userRepository.save(userCreateRequest.toEntity());
		return UserResponse.from(user);
	}
	
	public UserResponse findByEmail(String email) {
		User user = userRepository.findByEmail(email)
								.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		return UserResponse.from(user);
	}
	
	@Transactional
	public void delete(Long id) {
		log.info("USERSERVICE : delete");
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		userRepository.delete(user);
	}
	
	@Transactional
	public AdminResponse changeToAdmin(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다.")); 
		
		Admin admin = User.toAdmin(user);
		
		userRepository.delete(user);
		adminRepository.save(admin);
		
		return AdminResponse.from(admin);
	}
	
	public DeviceResponse findDeviceById(Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		
		if(Objects.isNull(user.getDevice())) {
			return null;
		}
		return DeviceResponse.from(user.getDevice());
	}
	
	public VillageResponse findVillageById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		
		if(Objects.isNull(user.getDevice())) {
			return null;
		}
		if(Objects.isNull(user.getDevice().getVillage())) {
			return null;
		}
		
		return VillageResponse.from(user.getDevice().getVillage());
		
	}
}
