package com.timcook.capstone;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.domain.Status;
import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.user.dto.UserUpdateRequest;
import com.timcook.capstone.village.domain.Address;
import com.timcook.capstone.village.domain.Village;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {

	private final InitService initService;
	
	@PostConstruct
	public void init() {
		initService.init();
	}
	
	@Component
	public static class InitService{
		
		@PersistenceContext
		EntityManager em;
		
		@Transactional
		public void init() {
			
			Village village = Village.builder().build();
			
			Admin admin = new Admin("test", "test", Role.ROLE_ADMIN, null, null, null, "01012341234");
			admin.registerVillage(village);
			
			Admin admin2 = new Admin("test2", "test2", Role.ROLE_ADMIN, null, null, null, "01012341234");
			em.persist(admin);
			em.persist(admin2);
			em.persist(village);
			
			for (int i=0;i<3;i++) {
				Device device = Device.builder()
									.village(village)
									.build();
				
				User user = User.builder()
						.username("user" + Integer.toString(i+1))
						.email("user" + Integer.toString(i+1))
						.role(Role.ROLE_USER)
						.device(device)
						.build();
				
				device.changeInfo(user, village);
				
				em.persist(user);
				em.persist(device);
			}
			
			em.persist(village);
			em.flush();
		}
		
	}
	
}
