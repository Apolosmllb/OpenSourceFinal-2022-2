package com.ecodrive.platform.u.si729ebu201920785.behaviour.api.rest;


import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.service.ScoreService;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.mapping.ScoreMapper;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.resource.CreateScoreResource;
import com.ecodrive.platform.u.si729ebu201920785.behaviour.resource.ScoreResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/drivers", produces = "application/json")
@Tag(name = "Scores", description = "Create, read  scores")
public class ScoresController {
    private final ScoreService scoreService;
    private final ScoreMapper mapper;

    public ScoresController(ScoreService scoreService, ScoreMapper mapper) {
        this.scoreService = scoreService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    @Operation(summary = "Get all Scores")
    public List<Score> getAllScores() {
        return scoreService.getAll();
    }


    @GetMapping("{driverId}/scores")
    @Operation(summary = "Get all Scores By Scope 0 and 1")
    public ResponseEntity<?> getAllScoresByScope(@RequestParam Long scope, @PathVariable Long driverId) {
        if(scope == 0 ) {
            double t = scoreService.getAverage(driverId);
            return ResponseEntity.ok("Promedio Total: "+t);
        }
        if(scope == 1 ) {
            double t = scoreService.getMax(driverId);
            return ResponseEntity.ok("Value Max: "  + t);
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("{driverId}/scores")
    @Operation(summary = "Post a Score")
    public ResponseEntity<ScoreResource> createStudent(@RequestBody CreateScoreResource resource, @PathVariable Long driverId) {
        return new ResponseEntity<>(mapper.toResource(
                scoreService.create(mapper.toModel(resource),driverId)),
                HttpStatus.CREATED);
    }
    /*@Operation(summary = "Create Student",
            responses = {@ApiResponse(description = "Student successfully created",
                    responseCode = "201", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ScoreResource.class)))})*/


}
