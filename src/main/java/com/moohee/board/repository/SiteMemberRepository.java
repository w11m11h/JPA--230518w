package com.moohee.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moohee.board.entity.SiteMember;

public interface SiteMemberRepository extends JpaRepository<SiteMember, Integer> {

}
