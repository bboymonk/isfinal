package com.isfinal.config.minIo;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.port}")
    private int port;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.secure}")
    private Boolean secure;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.configDir}")
    private String configDir;

    @Bean
    public MinioClient getMinioClient() throws Exception {
        MinioClient minioClient = new MinioClient(endpoint, port, accessKey, secretKey, secure);
        return minioClient;
    }

}
