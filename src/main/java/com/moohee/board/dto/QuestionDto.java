package com.moohee.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.moohee.board.entity.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
	
	private Integer id;
	private String subject;
	private String content;
	private LocalDateTime createDate;
	
	private List<Answer> answers;

}
