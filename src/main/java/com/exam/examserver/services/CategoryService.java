package com.exam.examserver.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Category;


@Service
public interface CategoryService {
	
	public Category addCategory(Category c);
	public Category updateCategory(Category c);
	public Set<Category>getCategories();
	public Category getCategory(Long cid);
	public void delereCategory(Long cid);
	

}
