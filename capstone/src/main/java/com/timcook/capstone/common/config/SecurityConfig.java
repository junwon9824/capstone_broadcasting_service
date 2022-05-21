package com.timcook.capstone.common.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.timcook.capstone.common.auth.PrincipalDetailsService;
import com.timcook.capstone.common.auth.handler.CustomAuthFailureHandler;
import com.timcook.capstone.common.auth.handler.CustomAuthSuccessHandler;
import com.timcook.capstone.common.auth.handler.CustomLogoutSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PrincipalDetailsService principalDetailsService;
	private final CustomAuthSuccessHandler customAuthSuccessHandler;
	private final CustomAuthFailureHandler customAuthFailureHandler;
	private final CustomLogoutSuccessHandler customLogoutSuccessHandler;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailsService).passwordEncoder(bCryptPasswordEncoder());
		
		auth.inMemoryAuthentication()
			.withUser("관리자")
			.password(bCryptPasswordEncoder().encode("1234"))
			.roles("USER").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.cors().configurationSource(corsConfigurationSource());
		
		http
				.authorizeRequests()
				.antMatchers("/api/notification/test/**,/api/users,/api/login/**,/css/**","/images/**","/js/**").permitAll()
				.antMatchers("/api/notification/token").authenticated()
				.antMatchers("/api/villages/**").authenticated()
				.antMatchers("/api/devices/**").authenticated()
				.antMatchers("/api/admins/**").hasRole("ADMIN")
				
//				.antMatchers("/api/notification/**,/api/admins/**,/api/villages/**,/api/devices/**").hasRole("ADMIN")
				.and()
				.formLogin()
				.usernameParameter("email")
				.loginProcessingUrl("/api/login")
				.successHandler(customAuthSuccessHandler)
				.failureHandler(customAuthFailureHandler)
				.and()
				.logout()
				.logoutUrl("/api/logout")
				.logoutSuccessHandler(customLogoutSuccessHandler);
//		http
//		.authorizeRequests()
//		.antMatchers("/users/**","/css/**","/images/**","/js/**").permitAll();
	}

	// cors 
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

//		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedOriginPatterns(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE","PUT"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


	
}
