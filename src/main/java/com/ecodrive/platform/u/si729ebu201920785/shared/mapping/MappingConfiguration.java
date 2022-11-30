package com.ecodrive.platform.u.si729ebu201920785.shared.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration  {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }

}
