package com.ecodrive.platform.u.si729ebu201920785.behaviour.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ecoDriveMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ScoreMapper studentMapper() {
        return new ScoreMapper();
    }

}
