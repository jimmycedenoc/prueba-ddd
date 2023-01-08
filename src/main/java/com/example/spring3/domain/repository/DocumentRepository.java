package com.example.spring3.domain.repository;

import com.example.spring3.domain.entity.Document;

public interface DocumentRepository {
  Document findById(String userId, String documentType);
}
