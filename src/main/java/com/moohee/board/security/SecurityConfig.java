package com.moohee.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //해당 클래스가 스프링 환경설정 클래스임을 알림
@EnableWebSecurity //모든 웹에 대한 요청이 스프링 시큐러티의 컨트롤 하에 있음을 알림
public class SecurityConfig {	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(
				new AntPathRequestMatcher("/**")).permitAll();
		return http.build();		
	} //모든 요청에 대하여 접근을 허락함

}
