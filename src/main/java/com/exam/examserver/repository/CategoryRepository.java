package com.exam.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	
	
	

}
