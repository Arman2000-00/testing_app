package com.example.testing.controller;

import com.example.testing.dto.request.QuestionRequest;
import com.example.testing.dto.response.QuestionResponse;
import com.example.testing.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionController {

  private final QuestionService questionService;

  @ApiOperation(value = "Save question")
  @PostMapping
  public ResponseEntity<HttpStatus> save(@RequestBody QuestionRequest questionRequest) {
    questionService.save(questionRequest);
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @ApiOperation(value = "Find all questions")
  @GetMapping
  public ResponseEntity<List<QuestionResponse>> findAll() {
    return ResponseEntity.ok(questionService.findAll());
  }

  @ApiOperation(value = "Find all questions by user id")
  @GetMapping("/{userId}")
  public ResponseEntity<List<QuestionResponse>> findAllByUserId(@PathVariable Long userId) {
    return ResponseEntity.ok(questionService.findByUserId(userId));
  }
}
