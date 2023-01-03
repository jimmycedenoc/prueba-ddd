package com.example.spring3.domain.entity;

import lombok.Data;

@Data
public class Document {
  private String id;
  private String userId;
  private String documentType;
  private String bucket;
  private String extension;
  private String path;
  private String url;
  private String startDate;
  private String endDate;
}
