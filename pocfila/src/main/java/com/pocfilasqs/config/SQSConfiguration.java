package com.pocfilasqs.config;

import io.awspring.cloud.sqs.config.SqsBootstrapConfiguration;
import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import io.awspring.cloud.sqs.listener.acknowledgement.handler.AcknowledgementMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Import(SqsBootstrapConfiguration.class)
@Configuration
public class SQSConfiguration {

    @Value("${spring.cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Bean
    public SqsMessageListenerContainerFactory<Object> defaultSqsListenerContainerFactory() {
        return SqsMessageListenerContainerFactory
                .builder()
                .configure(options -> options
                        .acknowledgementMode(AcknowledgementMode.ALWAYS)
                )
                .sqsAsyncClient(sqsAsyncClient())
                .build();
    }

    @Bean
    public SqsAsyncClient sqsAsyncClient(){
        return SqsAsyncClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentialsProvider()))
                .endpointOverride(URI.create("http://localhost:4566"))
                .build();
    }

    @Bean
    public AwsBasicCredentials awsCredentialsProvider(){
        return AwsBasicCredentials.create(accessKey, secretKey);
    }
}
