package com.bnh.wrestlim.controllers;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.bnh.wrestlim.beans.AWSCredentials;
import com.bnh.wrestlim.repositories.WrestlerImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/images")
@Document(collection = "/wrestlerImages")
@CrossOrigin
public class WrestlerImageController {
    @Autowired
    WrestlerImageRepository repository;

    AmazonS3 s3client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(AWSCredentials.awsCredentials))
            .withRegion(Regions.US_EAST_2)
            .build();
    String bucketName = "wrestlesim";
    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getImageByName(@PathVariable String name) throws IOException {
        // Get the image object from S3
        S3Object s3Object = s3client.getObject(bucketName, name);
        // Extract image content as byte array
        byte[] imageBytes = s3Object.getObjectContent().readAllBytes();
        // Set content type based on image format (e.g., "image/jpeg")
        String contentType = s3Object.getObjectMetadata().getContentType();
        // Build and return the response
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(imageBytes);
    }
    @PostMapping("/upload")
    public ResponseEntity<String> handleWrestlerImageUpload(@RequestParam("image") MultipartFile imageFile) {
        try {
            // Validate image file type
            if (!Objects.requireNonNull(imageFile.getContentType()).startsWith("image/")) {
                return ResponseEntity.badRequest().body("Invalid image file type");
            }
            // Generate a unique filename
            String filename = Objects.requireNonNull(imageFile.getOriginalFilename());
            // Upload image to S3 bucket
            s3client.putObject(
                    new PutObjectRequest(bucketName, filename, imageFile.getInputStream(), new ObjectMetadata())
            );
            imageFile.getInputStream().close();
            return ResponseEntity.ok(filename);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to upload image");
        }
    }
    private String generateUniqueFilename(String originalFilename) {
        int dotIndex = originalFilename.lastIndexOf(".");
        String extension = dotIndex > 0 ? originalFilename.substring(dotIndex + 1) : "";
        String baseName = dotIndex > 0 ? originalFilename.substring(0, dotIndex) : originalFilename;
        String uniqueSuffix = UUID.randomUUID().toString();
        return baseName + "-" + uniqueSuffix + "." + extension;
    }
}
