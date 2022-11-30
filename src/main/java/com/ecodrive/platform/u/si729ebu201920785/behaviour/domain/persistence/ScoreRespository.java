package com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.persistence;

import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.model.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreRespository extends JpaRepository<Score,Long> {

    @Query("SELECT  AVG (s.value )  FROM Score s WHERE s.driverId =?1")
    Double getAverage(Long driverId);

    @Query("SELECT  MAX(s.value )  FROM Score s WHERE s.driverId =?1")
    Double getMax(Long driverId);


}
