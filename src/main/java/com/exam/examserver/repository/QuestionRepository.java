package com.exam.examserver.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;


@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

	public Set<Question> findByQuiz(Quiz quiz);
	

	
	
	

}
