package com.example.spring3.application.mapper;

import com.example.spring3.application.response.DocumentResponse;
import com.example.spring3.domain.entity.Document;
import lombok.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@Generated
public interface DocumentMapper {
  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "userId")
  @Mapping(target = "documentType", source = "documentType")
  DocumentResponse toResponse(Document entity);
}
