package com.example.testing.service.impl;

import com.example.testing.dto.request.StatisticRequest;
import com.example.testing.dto.response.AnswerResponse;
import com.example.testing.entity.Statistic;
import com.example.testing.repository.StatisticRepository;
import com.example.testing.service.AnswerService;
import com.example.testing.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

  private final StatisticRepository statisticRepository;
  private final AnswerService answerService;
  private final ModelMapper modelMapper;

  /**
   * This method check questions`s answer which one answered right status would change true else
   * stay false
   *
   * @param statisticRequest
   */
  @Override
  public void checkAndSave(StatisticRequest statisticRequest) {
    if (statisticRequest.getQuestionId() != null) {
      AnswerResponse answer = answerService.findByQuestionId(statisticRequest.getQuestionId());
      Statistic statistic = new Statistic();
      modelMapper.map(statisticRequest, statistic);
      statistic.setUserId(statisticRequest.getCurrentUserId());
      if (answer != null && statisticRequest.getAnswer() != null) {
        if (answer.getCorrectAnswer().equalsIgnoreCase(statisticRequest.getAnswer().trim())) {
          statistic.setAnswered(true);

        }
        statisticRepository.save(statistic);
      }
    }
  }
}
