package com.exam.examserver.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;


@Service
public interface QuestionService {
	
	public Question addQuestion(Question que);
	public Question updateQuestion(Question que);
	public Set<Question> getAllQuestions();
	public Set<Question> getAllQuestionsOfQuiz(Quiz quiz);
	public Question getQuestion(Long queid);
	public void deleteQuestion(Long queid);
}
