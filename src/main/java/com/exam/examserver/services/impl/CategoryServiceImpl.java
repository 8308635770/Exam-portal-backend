package com.exam.examserver.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Category;
import com.exam.examserver.repository.CategoryRepository;
import com.exam.examserver.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public Category addCategory(Category c) {
		return this.categoryRepository.save(c);
	}

	@Override
	public Category updateCategory(Category c) {
		return this.categoryRepository.save(c);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long cid) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(cid).get();
	}

	@Override
	public void delereCategory(Long cid) {

		Category category=new Category();
		category.setCid(cid);
		this.categoryRepository.delete(category);
		
	}

}
