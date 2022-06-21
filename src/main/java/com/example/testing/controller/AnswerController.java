package com.example.testing.controller;

import com.example.testing.dto.request.AnswerRequest;
import com.example.testing.dto.response.AnswerResponse;
import com.example.testing.service.AnswerService;
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
@RequestMapping("/api/v1/answers")
public class AnswerController {

  private final AnswerService answerService;

  @ApiOperation(value = "Save answer")
  @PostMapping
  public ResponseEntity<HttpStatus> save(@RequestBody AnswerRequest answerRequest) {
    answerService.save(answerRequest);
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @ApiOperation(value = "Find all answers")
  @GetMapping
  public ResponseEntity<List<AnswerResponse>> findAll() {
    return ResponseEntity.ok(answerService.findAll());
  }

  @ApiOperation(value = "Find answer by questionId")
  @GetMapping("/{questionId}")
  public ResponseEntity<AnswerResponse> findByQuestionId(@PathVariable("questionId") Long id) {
    return ResponseEntity.ok(answerService.findByQuestionId(id));
  }
}
