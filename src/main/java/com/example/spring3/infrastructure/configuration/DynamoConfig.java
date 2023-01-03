package com.example.spring3.infrastructure.configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.example.spring3.infrastructure.repository")
public class DynamoConfig {
  @Value("${aws.dynamodb.end-point:}")
  private String endpoint;

  @Value("${spring.profiles.active:}")
  private String environment;

  @Bean
  public AmazonDynamoDB amazonDynamoDB(){
    var amazonDynamoDBClientBuilder = AmazonDynamoDBClientBuilder
        .standard().withCredentials(new DefaultAWSCredentialsProviderChain());
    if(environment.isEmpty()) {
      amazonDynamoDBClientBuilder
          .standard()
          .withRegion(Regions.US_EAST_1);
    }else{
      amazonDynamoDBClientBuilder
          .withEndpointConfiguration(
              new AwsClientBuilder.EndpointConfiguration(endpoint,
                  Regions.US_EAST_1.toString()));
    }
    return amazonDynamoDBClientBuilder.build();
  }
}
