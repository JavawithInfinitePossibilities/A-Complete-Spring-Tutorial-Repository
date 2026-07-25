package com.tutorials.sid.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Serves the file upload/download UI page.
 * URL: http://localhost:8080/Studentseminar/file/page
 *
 * @author kunmu On 25-07-2026
 */
@Controller
@RequestMapping("/file")
public class FileViewController {

    @GetMapping("/page")
    public String uploadPage() {
        return "UploadFile"; // resolves to src/main/resources/templates/UploadFile.html
    }
}
