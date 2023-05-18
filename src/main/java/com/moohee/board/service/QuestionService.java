package com.moohee.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moohee.board.entity.Question;
import com.moohee.board.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getQuestionList() {
		List<Question> questionList = questionRepository.findAll();
		
		return questionList;
	}

}
