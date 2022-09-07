package com.tutorials.sid.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorials.sid.spring.model.Question;
import com.tutorials.sid.spring.services.Impl.SurveyService;

/**
 * URL:http://localhost:8080/surveys/Survey1/questions/<br/>
 * http://localhost:8080/surveys/Survey1/questions/Question1
 * http://localhost:8080/actuator/
 * 
 * @author Lenovo
 *
 */

@RestController
@RequestMapping("/surveys")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@GetMapping("/{surveyId}/questions")
	public List<Question> retrieveQuestions(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}

	@GetMapping(path = "/{surveyId}/questions/{questionId}")
	public Question retrieveQuestion(@PathVariable String surveyId, @PathVariable("questionId") String questionValue) {
		return surveyService.retrieveQuestion(surveyId, questionValue);
	}

	@PostMapping("/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionToSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion) {
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		if (question == null)
			return ResponseEntity.noContent().build();

		// Success - URI of the new resource in Response Header
		// Status - created
		// URI -> /surveys/{surveyId}/questions/{questionId}
		// question.getQuestionId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId())
				.toUri();

		// Status
		return ResponseEntity.created(location).build();
	}
}