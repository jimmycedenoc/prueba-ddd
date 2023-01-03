package com.example.spring3.domain.services;

import com.example.spring3.domain.entity.Document;
import com.example.spring3.domain.repository.DocumentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DomainDocumentService implements DocumentService{
  private final DocumentRepository documentRepository;
  @Override
  public Document getDocumentById(String userId, String documentType) throws Exception {
    return documentRepository.findById(userId, documentType);
  }
}
