package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tutorials.sid.spring.controller.SurveyController;
import com.tutorials.sid.spring.model.Question;
import com.tutorials.sid.spring.services.Impl.SurveyService;

//@SpringBootTest(classes = Section05SpringBootDeepDivewithasimpleAPI.class)
@WebMvcTest(controllers = { SurveyController.class })
class Section05SpringBootDeepDivewithasimpleAPITestWebMvcTestMOCK {

	@Autowired
	private MockMvc mockMvc;

	// Mock @Autowired
	@MockBean
	private SurveyService surveyService;

	@Disabled
	@Test
	public void retrieveDetailsForQuestion() throws Exception {
		Question mockQuestion = new Question("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		Mockito.when(surveyService.retrieveQuestion(Mockito.anyString(), Mockito.anyString())).thenReturn(mockQuestion);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
		String contentAsString = result.getResponse().getContentAsString();
		System.out.println("Response body => " + contentAsString);
		//JSONAssert.assertEquals(expected, contentAsString, false);

		// Assert
	}

	@Test
	public void createSurveyQuestion() throws Exception {
		Question mockQuestion = new Question("1", "Smallest Number", "1", Arrays.asList("1", "2", "3", "4"));

		String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
		//surveyService.addQuestion to respond back with mockQuestion
		Mockito.when(surveyService.addQuestion(Mockito.anyString(), Mockito.any(Question.class)))
				.thenReturn(mockQuestion);

		//Send question as body to /surveys/Survey1/questions
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/surveys/Survey1/questions")
				.accept(MediaType.APPLICATION_JSON).content(questionJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/surveys/Survey1/questions/1", response.getHeader(HttpHeaders.LOCATION));

	}

}
