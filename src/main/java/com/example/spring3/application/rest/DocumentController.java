package com.example.spring3.application.rest;

import com.example.spring3.application.mapper.DocumentMapper;
import com.example.spring3.application.response.DocumentResponse;
import com.example.spring3.domain.services.DocumentService;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/document")
@AllArgsConstructor
public class DocumentController {
  private final DocumentMapper mapper;
  private final DocumentService documentService;
  @GetMapping(value = "/users/{userId}/types/{type}/startDate/{startDate}/endDate/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
  DocumentResponse getDocument(@PathVariable String userId,
      @PathVariable String type,
      @PathVariable @DateTimeFormat(pattern="yyyyMMdd") Date startDate,
      @PathVariable @DateTimeFormat(pattern="yyyyMMdd") Date endDate) throws Exception {
    return mapper.toResponse(documentService.getDocumentById(userId, type));
  }
}
