package com.exam.examserver.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.services.QuestionService;
import com.exam.examserver.services.QuizService;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;

	// create Question
	@PostMapping("/")
	public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}

	// update Question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get all questions
	@GetMapping("/")
	public ResponseEntity<?> getAllQuestions(){
		return ResponseEntity.ok(this.questionService.getAllQuestions());
	}
	
	//get all quetions of any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQAllQuestionsOfQuizToUser(@PathVariable("qid") Long qid){
		
//		 Quiz quiz=new Quiz();
//		 quiz.setId(qid);
//		 Set<Question>questions=this.questionService.getAllQuestionsOfQuiz(quiz);
//		 return ResponseEntity.ok(questions);
		Quiz quiz=this.quizService.getQuiz(qid);
		Set<Question>questions=quiz.getQuestions();
		List<Question> list=new ArrayList<>(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuetions())) {
			list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuetions()));
			
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);	
	}
	
	@GetMapping("/admin/quiz/{qid}")
	public ResponseEntity<?> getQAllQuestionsOfQuizToAdmin(@PathVariable("qid") Long qid){
		
//		 Quiz quiz=new Quiz();
//		 quiz.setId(qid);
//		 Set<Question>questions=this.questionService.getAllQuestionsOfQuiz(quiz);
//		 return ResponseEntity.ok(questions);
		Quiz quiz=this.quizService.getQuiz(qid);
		Set<Question>questions=quiz.getQuestions();
		List<Question> list=new ArrayList<>(questions);
		Collections.shuffle(list);
		return ResponseEntity.ok(list);	
	}
	
	//get single question
	@GetMapping("/{queid}")
	public Question get(@PathVariable("queid") Long queId) {
		return this.questionService.getQuestion(queId);
	}
	
	//delete Question
	@DeleteMapping("/{queid}")
	public void deleteQuestion(@PathVariable("queid") long queId) {
		this.questionService.deleteQuestion(queId);
	}
	
	
}
