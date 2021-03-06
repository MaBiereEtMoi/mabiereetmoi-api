package com.mabiereetmoi.api.storage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ReadChannel;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.cloud.storage.*;


@Service
public class StorageService {

    private final Logger log = LoggerFactory.getLogger(StorageService.class);
    private String bucketName;
    private StorageOptions storageOptions;

    @PostConstruct
    private void initializeFirebase() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = new ClassPathResource("firebase_config.json").getInputStream();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        bucketName = "mabiereetmoi.appspot.com";

        this.storageOptions = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(inputStream)).build();

    }

    public ResponseEntity<Object> downloadFile(String fileName, HttpServletRequest request) throws Exception {
        Storage storage = storageOptions.getService();

        Blob blob = storage.get(BlobId.of(bucketName, fileName));
        ReadChannel reader = blob.reader();
        InputStream inputStream = Channels.newInputStream(reader);

        byte[] content = null;
        log.info("File downloaded successfully.");

        content = IOUtils.toByteArray(inputStream);

        final ByteArrayResource byteArrayResource = new ByteArrayResource(content);

        return ResponseEntity
                .ok()
                .contentLength(content.length)
                .header("Content-type", "application/octet-stream")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(byteArrayResource);

    }

    public FileDto uploadFile(MultipartFile multipartFile, String folderName, String fileName) throws IOException {
        File file = convertMultiPartToFile(multipartFile);
        Path filePath = file.toPath();

        Map<String, String> map = new HashMap<>();
        map.put("firebaseStorageDownloadTokens", fileName);
        Storage storage = storageOptions.getService();

        BlobId blobId = BlobId.of(bucketName,  folderName + "/" + fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setMetadata(map)
                .setContentType(multipartFile.getContentType()).build();
        Blob blob = storage.create(blobInfo, Files.readAllBytes(filePath));

        log.info("File " + filePath + " uploaded to bucket " + bucketName + " as " + fileName);
        String[] uploadedFile = new String[]{"fileUrl", fileName};
        String fileDownloadUri = uploadedFile[0];
        log.info("fileDownloadUri, {0}" + fileDownloadUri);
        log.info("filename, {0}" + fileName);

        return new FileDto(
                fileName,
                multipartFile.getContentType(),
                blob.getMediaLink(), multipartFile.getSize());
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    private String generateFileName() {
        return new Date().getTime() + "-" + "avatar";
    }

}
