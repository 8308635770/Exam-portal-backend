package com.exam.examserver.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Category;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.repository.QuizRepository;
import com.exam.examserver.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz q) {
		return this.quizRepository.save(q);
	}

	@Override
	public Quiz updateQuiz(Quiz q) {
		return this.quizRepository.save(q);
	}

	@Override
	public Set<Quiz> getAllquizzes() {
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long qid) {
		return this.quizRepository.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {
		this.quizRepository.deleteById(qid);
	}

	@Override
	public Set<Quiz> getAllquizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
//		sy
		return quizRepository.findByCategory(category);
	}

	@Override
	public Set<Quiz> getAllActiveQuizzes() {
		// TODO Auto-generated method stub
		return quizRepository.findByActive(true);
	}

	@Override
	public Set<Quiz> getAllActiveQuizzesOfCategory(boolean active,Category category) {
		// TODO Auto-generated method stub
		return quizRepository.findByActiveAndCategory(active, category);
	}



}
