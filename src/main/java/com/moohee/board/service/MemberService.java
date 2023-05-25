package com.moohee.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moohee.board.entity.SiteMember;
import com.moohee.board.repository.SiteMemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private SiteMemberRepository siteMemberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public SiteMember memberJoin(String userid, String userpw, String email) {
		
		SiteMember siteMember = new SiteMember();
		siteMember.setUsername(userid);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		siteMember.setUserpw(passwordEncoder.encode(userpw));
		//유저가 입력한 암호를 hash함수로 암호화하여 암호문을 DB에 저장
		
//		siteMember.setUserpw(userpw);
		siteMember.setEmail(email);
		
		siteMemberRepository.save(siteMember);		
		
		return siteMember;
		
	}

}
