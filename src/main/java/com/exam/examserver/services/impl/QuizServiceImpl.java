package com.exam.examserver.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
		this.quizRepository.delete(quiz);
	}

}
