package com.exam.examserver.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entity.Category;
import com.exam.examserver.entity.Quiz;


@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
	
	public Set<Quiz> findByCategory(Category category);
	public Set<Quiz> findByActive(boolean active);
	public Set<Quiz> findByActiveAndCategory(boolean active,Category category);
	
	


}
