package com.exam.examserver.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Quiz;


@Service
public interface QuizService {
	
	public Quiz addQuiz(Quiz q);
	public Quiz updateQuiz(Quiz q);
	public Set<Quiz> getAllquizzes();
	public Quiz getQuiz(Long qid);
	public void deleteQuiz(Long qid);

}
