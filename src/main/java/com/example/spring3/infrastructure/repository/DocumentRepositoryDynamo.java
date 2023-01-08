package com.example.spring3.infrastructure.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.spring3.domain.entity.Document;
import com.example.spring3.domain.repository.DocumentRepository;
import com.example.spring3.infrastructure.entity.DocumentEntity;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentRepositoryDynamo implements DocumentRepository {

  private final DynamoDBMapper dynamoDBMapper;
  @Override
  public Document findById(String userId, String documentType) {
    return dynamoDBMapper.query(DocumentEntity.class, getQueryExpression(userId, documentType)).stream().findFirst()
        .orElseThrow(() -> new RuntimeException("{document.not.found}"));
  }

  private DynamoDBQueryExpression<DocumentEntity> getQueryExpression (String userId, String documentType) {
    Map<String, AttributeValue> params = new HashMap<>();
    params.put(":userId", new AttributeValue().withS(userId));
    params.put(":documentType", new AttributeValue().withS(documentType));
    return new DynamoDBQueryExpression().withKeyConditionExpression("user_id=:userId and document_type=:documentType")
        .withExpressionAttributeValues(params)
        .withIndexName("UserTypeIndex");
  }
}
