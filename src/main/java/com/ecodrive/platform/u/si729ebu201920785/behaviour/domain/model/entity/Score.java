package com.ecodrive.platform.u.si729ebu201920785.behaviour.domain.model.entity;


import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private Long driverId;

    @NotNull
    @Column
    private Double value;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registeredAt;
}
