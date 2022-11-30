package com.ecodrive.platform.u.si729ebu201920785.behaviour.resource;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ScoreResource {
    private Long driverId;
    private Double value;
    private  Date registeredAt;
}
