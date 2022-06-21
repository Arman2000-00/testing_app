package com.example.testing.mapper;

import com.example.testing.dto.request.StatisticRequest;
import com.example.testing.entity.Statistic;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticMapper {

  private final ModelMapper modelMapper;

  public Statistic toEntity(StatisticRequest statisticRequest) {
    return modelMapper.map(statisticRequest, Statistic.class);
  }
}
