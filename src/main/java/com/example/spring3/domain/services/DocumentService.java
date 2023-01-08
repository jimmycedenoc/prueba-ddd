package com.example.spring3.domain.services;

import com.example.spring3.domain.entity.Document;

public interface DocumentService {
  Document getDocumentById(String userId, String documentType);
}
