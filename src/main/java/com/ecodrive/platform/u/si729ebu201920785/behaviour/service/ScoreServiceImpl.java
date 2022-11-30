package com.ecodrive.platform.u.si729ebu201920785.behaviour.service;


import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.persistence.ScoreRespository;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.service.ScoreService;
import com.ecodrive.platform.u.si729ebu201920785.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;



import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ScoreServiceImpl implements ScoreService {
    private static final String ENTITY = "Score";

    private final ScoreRespository scoreRespository;

    private final Validator validator;


    public ScoreServiceImpl(ScoreRespository scoreRespository, Validator validator) {
        this.scoreRespository = scoreRespository;
        this.validator = validator;
    }


    @Override
    public Score create(Score score,  Long driverId) {

        // Constraints validation
        Set<ConstraintViolation<Score>> violations = validator.validate(score);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        score.setDriverId(driverId);
        score.setRegisteredAt(new Date());
        return scoreRespository.save(score);
    }

    @Override
    public List<Score> getAll() {
        return scoreRespository.findAll();
    }

    @Override
    public Double getAverage(Long driverId) {
        return scoreRespository.getAverage(driverId);
    }

    @Override
    public Double getMax(Long driverId) {
        return scoreRespository.getMax(driverId);
    }




}
