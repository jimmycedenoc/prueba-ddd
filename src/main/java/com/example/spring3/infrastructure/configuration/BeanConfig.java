package com.example.spring3.infrastructure.configuration;

import com.example.spring3.domain.repository.DocumentRepository;
import com.example.spring3.domain.services.DocumentService;
import com.example.spring3.domain.services.DomainDocumentService;
import com.example.spring3.infrastructure.Spring3Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Spring3Application.class)
public class BeanConfig {
  @Bean
  DocumentService documentService(final DocumentRepository documentRepository) {
    return new DomainDocumentService(documentRepository);
  }
}
