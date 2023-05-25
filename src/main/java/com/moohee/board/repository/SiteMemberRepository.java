package com.moohee.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moohee.board.entity.SiteMember;

public interface SiteMemberRepository extends JpaRepository<SiteMember, Integer> {
	
	public Optional<SiteMember> findByUsername(String username);

}
