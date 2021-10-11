package com.exam.examserver.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.repository.QuestionRepository;
import com.exam.examserver.services.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository queRepository;

	@Override
	public Question addQuestion(Question que) {
		return this.queRepository.save(que);
	}

	@Override
	public Question updateQuestion(Question que) {
		return this.queRepository.save(que);

	}

	@Override
	public Set<Question> getAllQuestions() {
		return new LinkedHashSet<>(this.queRepository.findAll());
	}

	@Override
	public Set<Question> getAllQuestionsOfQuiz(Quiz quiz) {
		return this.queRepository.findByQuiz(quiz);
	}

	@Override
	public Question getQuestion(Long queid) {
		return this.queRepository.findById(queid).get();
	}

	@Override
	public void deleteQuestion(Long queid) {
		// TODO Auto-generated method stu
		Question question=new Question();
		question.setQueId(queid);
		this.queRepository.delete(question);
		
	}

}
