package com.timcook.capstone.user.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.timcook.capstone.village.domain.Village;
import com.timcook.capstone.village.dto.VillageResponse;
import com.timcook.capstone.village.repository.VillageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;
	private final AdminRepository adminRepository;
	private final VillageRepository villageRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Value("${user.password}")
	private String PASSWORD;
	
	public List<UserResponse> findAll(){
		return userRepository.findAll().stream()
				.filter(user -> user.getRole().equals(Role.ROLE_USER))
				.map(user -> UserResponse.from(user))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public UserResponse register(UserCreateRequest userCreateRequest) {
		userCreateRequest.setPassword(bCryptPasswordEncoder.encode(PASSWORD));

		if(userRepository.findByEmail(userCreateRequest.getEmail()).isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 회원입니다.");
		}
		
		User user = userCreateRequest.toEntity();
		userRepository.save(user);
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
		
		if(!Objects.isNull(user.getVillage().getAdmin())) {
			throw new IllegalArgumentException("이미 이장이 존재합니다.");
		}

		Admin admin = user.toAdmin();
		
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
		
		return VillageResponse.from(user.getVillage());
	}
	
	@Transactional
	public void registerVillage(Long id, Long villageId) {
		log.info("---[USER] REGISTER VILLAGE---");
		log.info("USER-ID : {}, VILLAGE-ID : {}", id, villageId);
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		
		Village village = villageRepository.findById(villageId)
				.orElseThrow(() -> new IllegalArgumentException("없는 마을 번호입니다."));
		
		user.registerVillage(village);
	}
	
	public UserResponse getWard(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		
		return UserResponse.from(user.getWard());
	}
		
	@Transactional
	public void registerGaurdian(Long id, Long guardianId) {
		User ward = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

		User guardian = userRepository.findById(guardianId)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

		
		ward.addGaurdian(guardian);
	}
	
	
}
