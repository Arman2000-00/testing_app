package com.example.testing.controller;

import com.example.testing.dto.request.StatisticRequest;
import com.example.testing.service.StatisticService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistics")
public class StatisticController {

  private final StatisticService statisticService;

  @ApiOperation(value = "Save statistic result")
  @PostMapping
  public ResponseEntity<HttpStatus> save(@RequestBody StatisticRequest statisticRequest) {
    statisticService.checkAndSave(statisticRequest);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}
