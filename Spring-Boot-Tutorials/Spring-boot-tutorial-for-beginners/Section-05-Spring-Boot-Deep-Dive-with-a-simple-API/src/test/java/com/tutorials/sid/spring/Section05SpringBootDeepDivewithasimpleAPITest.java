package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.tutorials.sid.spring.model.Question;

@SpringBootTest(classes = Section05SpringBootDeepDivewithasimpleAPI.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Section05SpringBootDeepDivewithasimpleAPITest {

	@LocalServerPort
	private int port;

	@Disabled
	@Test
	public void testRetrieveSurveyQuestion() throws JSONException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		String body = response.getBody();
		System.out.println("Response body =>" + body);
		String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";
		JSONAssert.assertEquals(expected, body, false);
	}

	@Disabled
	@Test
	public void retrieveAllSurveyQuestions() throws Exception {

		String url = "http://localhost:" + port + "/surveys/Survey1/questions";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		ResponseEntity<List<Question>> response = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<String>("DUMMY_DOESNT_MATTER", headers),
				new ParameterizedTypeReference<List<Question>>() {
				});

		Question sampleQuestion = new Question("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));

		assertTrue(response.getBody().contains(sampleQuestion));
	}

	@Test
	public void addQuestion() {
		String url = "http://localhost:" + port + "/surveys/Survey1/questions";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		Question question = new Question("DOESNTMATTER", "Question1", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));

		HttpEntity entity = new HttpEntity<Question>(question, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		System.out.println("The actual value : => " + actual);
		assertTrue(actual.contains("/surveys/Survey1/questions/"));
	}

}
