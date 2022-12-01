package com.ecodrive.platform.u.si729ebu201920785.behaviour.mapping;


import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.resource.CreateScoreResource;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.resource.ScoreResource;
import com.ecodrive.platform.u.si729ebu201920785.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class ScoreMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public ScoreResource toResource(Score model) {
        return mapper.map(model, ScoreResource.class);
    }
    public Page<ScoreResource> modelListPage(List<Score> modelList,
                                             Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList,
                ScoreResource.class), pageable, modelList.size());
    }
    public Score toModel(CreateScoreResource resource) {
        return mapper.map(resource, Score.class);
    }
}
