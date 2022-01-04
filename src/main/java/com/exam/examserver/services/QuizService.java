package com.exam.examserver.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Category;
import com.exam.examserver.entity.Quiz;


@Service
public interface QuizService {
	
	public Quiz addQuiz(Quiz q);
	public Quiz updateQuiz(Quiz q);
	public Set<Quiz> getAllquizzes();
	public Quiz getQuiz(Long qid);
	public void deleteQuiz(Long qid);
	public Set<Quiz> getAllquizzesOfCategory(Category category);
	public Set<Quiz> getAllActiveQuizzes();
	public Set<Quiz> getAllActiveQuizzesOfCategory(boolean active,Category category);

}
