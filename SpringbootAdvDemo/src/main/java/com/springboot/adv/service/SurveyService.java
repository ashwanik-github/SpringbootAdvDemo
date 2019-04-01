package com.springboot.adv.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.adv.model.Question;
import com.springboot.adv.model.Survey;

@Component
public class SurveyService {
	//we are using here the List as the DataSource here
	private static List<Survey>surveys= new ArrayList<>();
	
	//creating a static block for the set of harcoded questions
	static {
		Question question1 = new Question
				("Question1","Largest Country in the World?","Russia",Arrays.asList("India","China","Russia","United States"));
		Question question2 = new Question
				("Question2","Who was first the Prime Minister of India?","Pt. Jawahar Lal Nehru",Arrays.asList("Pt. Jawahar Lal Nehru",
						"Dr. Rajendra Prasad","Indira Gandhi","Lal Bahadur Sastri"));
		Question question3 = new Question
				("Question3","Largest Demoracy in the World?","India",Arrays.asList("India","China","Russia","United States"));
		Question question4 = new Question
				("Question4","Which is the largest river in the world?","Amazon",Arrays.asList("Nile","Ganga","Amazon","Tsang-Po"));
		Question question5 = new Question
				("Question5","Who is the richest person on earth?","Jeff Bezos",Arrays.asList("Mukesh Ambani","Warren Buffet","Bill Gates","Jeff Bezos"));
		Question question6 = new Question
				("Question6","which is the country having the largest GDP?","United States",Arrays.asList("India","China","Russia","United States"));
		//adding the list of questions in the array list hereby
		List<Question>questions = new ArrayList<>(Arrays.asList(question1,question2,question3,question4,question5,question6));
		Survey survey = new Survey("Survey1", "TalentWiz", "One of the most awaited Survey for General Awareness!!", questions);
		//adding to the list of survey
		surveys.add(survey);
	}//end of Static Block
	
	public List<Survey>retrieveAllSurveys(){
		return surveys;
	}
	public Survey retrieveSurvey(String surveyID) {
		for (Survey survey : surveys) {
			if (survey.getId().equals(surveyID)) {
				return survey;
			}
		}
		return null;
	}
	public List<Question> retrieveQuestions(String surveyId){
		Survey survey = retrieveSurvey(surveyId);
		
		if(survey==null) {
			return null;
		}
		return survey.getQuestions();
	}
	public Question retrieveQuestion(String surveyID,String questionId){
		Survey survey = retrieveSurvey(surveyID);
		if(survey==null) {
			return null;
		}
		for (Question question : survey.getQuestions()) {
			if(question.getId().equals(questionId)) {
				return question;
			}
		}
		return null;
	}
	private SecureRandom random = new SecureRandom();
	
	public Question addQuestion(String surveyId, Question question) {
		 Survey survey = retrieveSurvey(surveyId);
		 if (survey == null) {
			return null;
		}
		 String randomId = new BigInteger(130,random).toString(32);
		 question.setId(randomId);
		 survey.getQuestions().add(question);
		 return question;
	}
	
}
