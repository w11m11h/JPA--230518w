package com.moohee.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //해당 클래스가 스프링 환경설정 클래스임을 알림
@EnableWebSecurity //모든 웹에 대한 요청이 스프링 시큐러티의 컨트롤 하에 있음을 알림
public class SecurityConfig {	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(
				new AntPathRequestMatcher("/**")).permitAll()
			
			//로그인과 로그아웃 관련 설정
			.and() //로그인 설정
				.formLogin()
				.loginPage("/login") //로그인 페이지가 보이게 하는 요청(기본 파라미터값 username, password)
//				.usernameParameter("userid")
				.passwordParameter("userpw")
				.defaultSuccessUrl("/index") //로그인 성공시 이동할 페이지의 요청
			.and() //로그아웃 설정
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃 요청
				.logoutSuccessUrl("/index") //로그아웃 성공시 이동할 페이지의 요청
				.invalidateHttpSession(true) //세션삭제->로그아웃
		;
		return http.build();		
	} //모든 요청에 대하여 접근을 허락함
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
}
