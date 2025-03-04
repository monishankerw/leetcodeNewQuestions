package com.leetcode.leetcode.microservices.AWS.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
public class S3Service {
    private final S3Client s3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    public S3Service(@Value("${aws.accessKey}") String accessKey,
                     @Value("${aws.secretKey}") String secretKey,
                     @Value("${aws.region}") String region) {
        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                .build();
    }

    public String uploadFile(MultipartFile file, String folderPath) {
        String fileName = folderPath + "/" + file.getOriginalFilename();
        try {
            s3Client.putObject(
                    PutObjectRequest.builder().bucket(bucketName).key(fileName).build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));
            return "File uploaded successfully: " + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Error uploading file", e);
        }

    }

    public byte[] downloadFile(String filePath) throws IOException {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(filePath)
                .build();
        return s3Client.getObject(getObjectRequest).readAllBytes();
    }
    public String deleteFile(String filePath) {
        s3Client.deleteObject(DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(filePath)
                .build());
        return "File deleted successfully: " + filePath;
    }
}
