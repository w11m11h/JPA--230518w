package com.moohee.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moohee.board.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
