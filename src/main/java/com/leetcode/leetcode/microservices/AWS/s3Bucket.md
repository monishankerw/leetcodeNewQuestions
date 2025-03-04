# S3 File Upload & Download in Spring Boot

## Prerequisites

- **AWS S3 Bucket**
- **AWS Access Key & Secret Key**
- **Spring Boot Application**

---

## 1. Add Dependencies

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>s3</artifactId>
    <version>2.17.89</version> <!-- Use latest version -->
</dependency>
```

---

## 2. Configure AWS Credentials

### **Option 1: Use AWS CLI Credentials**

Create `~/.aws/credentials`:

```ini
[default]
aws_access_key_id=your-access-key
aws_secret_access_key=your-secret-key
region=us-east-1
```

### **Option 2: Use **``

```properties
aws.accessKey=your-access-key
aws.secretKey=your-secret-key
aws.region=us-east-1
aws.bucketName=your-bucket-name
```

---

## 3. Create S3 Service

```java
package com.example.s3service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

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

    public byte[] downloadFile(String filePath) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(filePath)
                .build();
        return s3Client.getObject(getObjectRequest).readAllBytes();
    }
}
```

---

## 4. Create REST Controller

```java
package com.example.s3service.controller;

import com.example.s3service.service.S3Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/s3")
public class S3Controller {
    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("path") String folderPath) {
        String message = s3Service.uploadFile(file, folderPath);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("path") String filePath) {
        byte[] data = s3Service.downloadFile(filePath);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filePath)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }
}
```

---

## 5. Test the API

### **Upload File**

```http
POST http://localhost:8080/s3/upload
Content-Type: multipart/form-data
```

**Form Data:**

- `file`: Select a file
- `path`: `uploads/user123`

### **Download File**

```http
GET http://localhost:8080/s3/download?path=uploads/user123/filename.jpg
```

---

## 6. Delete File (Optional)

### **Add Method in S3Service**

```java
public String deleteFile(String filePath) {
    s3Client.deleteObject(DeleteObjectRequest.builder()
            .bucket(bucketName)
            .key(filePath)
            .build());
    return "File deleted successfully: " + filePath;
}
```

### **Expose Delete API in Controller**

```java
@DeleteMapping("/delete")
public ResponseEntity<String> deleteFile(@RequestParam("path") String filePath) {
    String message = s3Service.deleteFile(filePath);
    return ResponseEntity.ok(message);
}
```

### **Test Delete API**

```http
DELETE http://localhost:8080/s3/delete?path=uploads/user123/filename.jpg
```

---

## 7. Conclusion

- ✅ **Upload, Download, and Delete files** in an **AWS S3 bucket**.
- ✅ **Store files in subdirectories (Multipath Support)**.
- ✅ **Use RESTful APIs** to interact with AWS S3.

This implementation provides a robust way to handle file operations in S3 using Spring Boot. 🚀

