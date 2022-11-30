package com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.service;

import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.model.entity.Score;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreService {

    Score create(Score score, Long driverId);

    List<Score> getAll();

    Double getAverage(Long driverId);

    Double getMax(Long driverId);


}
