package com.liftbro.backend.config;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource() {
        AwsSecretsDTO secrets = getSecret();
        return DataSourceBuilder
                .create()
//                .driverClassName("com.mysql.cj.jdbc.driver")
                .url("jdbc:"+secrets.getEngine()+"://"+secrets.getHost()+":"+secrets.getPort()+"/LiftbroDB")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }

    private AwsSecretsDTO getSecret() {

//        String secretName = "LiftBroDBSecret";
        String secretName = "prod/LiftBroDB";
        Region region = Region.of("us-west-2");

        // Supply credentials
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);

        // Create a Secrets Manager client
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }

        String secret = getSecretValueResponse.secretString();

        // Your code goes here.
        return gson.fromJson(secret, AwsSecretsDTO.class);
    }
}
