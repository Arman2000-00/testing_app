package com.example.testing.service;

import com.example.testing.dto.request.StatisticRequest;

public interface StatisticService {

  void checkAndSave(StatisticRequest statisticRequest);
}
