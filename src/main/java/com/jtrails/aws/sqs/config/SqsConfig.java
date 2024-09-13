package com.jtrails.aws.sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

/**
 * @author Lejil
 *
 */
@Configuration
public class SqsConfig {

	@Value("${aws.sqs.acc-key}")
	private String accessKey;

	@Value("${aws.sqs.sec-key}")
	private String secretKey;

	@Value("${aws.sqs.region}")
	private String awsRegion;

	@Bean
	SqsAsyncClient sqsAsyncClient() {
		return SqsAsyncClient.builder().region(Region.of(awsRegion))
				.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
				.build();
	}

	@Bean
	SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
		return SqsTemplate.builder().sqsAsyncClient(sqsAsyncClient).build();
	}

	@Bean
	ObjectMapper mapper() {
		return new ObjectMapper();
	}

}