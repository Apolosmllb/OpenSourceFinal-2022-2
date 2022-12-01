package com.ecodrive.platform.u.si729ebu201920785.behaviour.resource;

import lombok.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateScoreResource {
    @NotNull
    private Double value;
}
