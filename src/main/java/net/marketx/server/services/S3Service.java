package net.marketx.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String key = UUID.randomUUID().toString() + "-" + fileName;
        PutObjectRequest request = PutObjectRequest.builder()
            .bucket(bucketName)
            .key(key)
            .build();
        PutObjectResponse response = s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        s3Client.putObjectAcl(PutObjectAclRequest.builder()
            .bucket(bucketName)
            .key(key)
            .acl(ObjectCannedACL.PUBLIC_READ)
            .build());

        String objectUrl = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toString();

        return objectUrl;
    }
}

