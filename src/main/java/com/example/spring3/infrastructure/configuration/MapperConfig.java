package com.example.spring3.infrastructure.configuration;

import com.example.spring3.application.mapper.DocumentMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
  @Bean
  public DocumentMapper documentMapper(){
    return Mappers.getMapper(DocumentMapper.class);
  }
}
