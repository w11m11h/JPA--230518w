package com.moohee.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moohee.board.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
