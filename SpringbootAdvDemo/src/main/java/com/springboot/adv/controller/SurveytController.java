package com.springboot.adv.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.adv.model.Question;
import com.springboot.adv.service.SurveyService;

@RestController
public class SurveytController {
	@Autowired
	private SurveyService surveyService;

	// creating the method which will take the rest call from user
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId) {
		// returns all the question hereby
		return surveyService.retrieveQuestions(surveyId);

	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		// return only the question that is being queried
		return surveyService.retrieveQuestion(surveyId, questionId);

	}

	@PostMapping("/surveys/{surveyId}/questions") // adding the @RequestBody annotation to map the response to
													// QuestionObject
	public ResponseEntity<Object> addQuestionToSurvey(@PathVariable String surveyId,
			@RequestBody Question newQuestion) {
		// Success the result of the new Question being created and return the new URI
		Question question = surveyService.addQuestion(surveyId, newQuestion);

		// check if the question added is non-existent
		if (question == null) {
			return ResponseEntity.noContent().build();
		}

		// now we need to check the URI so that the new object is created successfully
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
