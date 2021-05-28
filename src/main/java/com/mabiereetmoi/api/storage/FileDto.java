package com.mabiereetmoi.api.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    private String fileName;
    private String contentType;
    private String fileDownloadUri;
    private Long fileSize;

}
