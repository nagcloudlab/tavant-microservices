package com.example.instamediaservice.api;

import com.example.instamediaservice.model.ImageMetaData;
import com.example.instamediaservice.payload.UploadFileResponse;
import com.example.instamediaservice.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class ImageUploadApi {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/images")
    public UploadFileResponse uploadFile(@RequestParam("image")MultipartFile file){
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        log.info("received a request to upload file {} for user {}", filename, "anonymous");
        ImageMetaData metadata= imageService.upload(file,"anonymous");
        return new UploadFileResponse(metadata.getFilename(), metadata.getUri(),metadata.getFileType());
    }

}
