package com.leetcode.leetcode.microservices.AWS.s3;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public ResponseEntity<byte[]> downloadFile(@RequestParam("path") String filePath) throws IOException {
        byte[] data = s3Service.downloadFile(filePath);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filePath)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam("path") String filePath) {
        String message = s3Service.deleteFile(filePath);
        return ResponseEntity.ok(message);
    }
}