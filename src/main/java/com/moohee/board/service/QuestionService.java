package com.moohee.board.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moohee.board.entity.Question;
import com.moohee.board.entity.SiteMember;
import com.moohee.board.exception.DataNotFoundException;
import com.moohee.board.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getQuestionList() {
		List<Question> questionList = questionRepository.findAll();
		
		return questionList;
	}
	
	public Question getQuestion(Integer id) {
		
		Optional<Question> optQuestion = questionRepository.findById(id); //1개 반환되거나 없거나
		
		if(optQuestion.isPresent()) {
			Question question = optQuestion.get();			
			return question;
		} else {
			throw new DataNotFoundException("선택하신 질문은 없는 글입니다.");
		}		
		
	}
	public void questionCreate(String subject, String content, SiteMember writer) {
		
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setWriter(writer);
		question.setCreateDate(LocalDateTime.now());//서버의 현재시간 입력
		
		questionRepository.save(question);
	}

	public void questionModify(Question question, String subject, String content) {
		
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now()); //현재 시간을 가져와서 수정 시간으로 입력
		
		questionRepository.save(question);
		
	}

}
