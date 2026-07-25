package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;


/**
 * Unit test for simple Division19RESTFileUploadAndDownload.
 */
@SpringBootTest(classes = Division19RESTFileUploadAndDownload.class)
public class Division19RESTFileUploadAndDownloadTest {
    @Test
    void test() {
    }

    private static final String DOWNLOAD_PATH = "E:/DownloadFileForJavaPractices/";
    private static final String DOWNLOAD_URL = "http://localhost:8080/Studentseminar/file/download/";
    private static final String FILE_UPLOAD_URL = "http://localhost:8080/Studentseminar/file/upload";
    @Autowired
    RestTemplate restTemplate;

    @Test
    void testUpload() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new ClassPathResource("PP.jpg"));
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(body, headers);
        ResponseEntity<Boolean> response = restTemplate.postForEntity(FILE_UPLOAD_URL, httpEntity, Boolean.class);
        System.out.println(response.getBody());
    }

    @Test
    void testDownload() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        String fileName = "pp.jpg";
        ResponseEntity<byte[]> response = restTemplate
                .exchange(DOWNLOAD_URL + fileName, HttpMethod.GET, httpEntity, byte[].class);
        Files.write(Paths.get(DOWNLOAD_PATH + fileName), response.getBody());
    }
}
