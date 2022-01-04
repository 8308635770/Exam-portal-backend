package com.exam.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.Category;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz>updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get all quiz
	@GetMapping("/")
	public ResponseEntity<?> getAllQuizzes(){
		return ResponseEntity.ok(this.quizService.getAllquizzes());
	}
	
	//get quiz of category
	@GetMapping("/category/{cid}")
	public ResponseEntity<?>getQuizOfCategory(@PathVariable("cid") Long cid){
		Category category=new Category();
		category.setCid(cid);
		return ResponseEntity.ok(this.quizService.getAllquizzesOfCategory(category));
	}
	
	//get all active quizzes
	@GetMapping("/active")
	public ResponseEntity<?>getAllActiveQuizzes(){
		return ResponseEntity.ok(this.quizService.getAllActiveQuizzes());
	}
	
	//get all active quizzes of category
	@GetMapping("/category/active/{cid}")
	public ResponseEntity<?>getAllActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category=new Category();
		category.setCid(cid);
		return ResponseEntity.ok(this.quizService.getAllActiveQuizzesOfCategory(true,category));
	}
	
	//get Quiz
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid") Long qid) {
		return this.quizService.getQuiz(qid);
	}
	
	//delete quiz
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") Long qid) {
		this.quizService.deleteQuiz(qid);
	}
	

}
