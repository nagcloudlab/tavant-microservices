package com.example.instamediaservice.service;

import com.example.instamediaservice.model.ImageMetaData;
import com.example.instamediaservice.repository.ImageMetadataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
@Slf4j
public class ImageService {

    @Autowired
    FileStorageService fileStorageService;

    //@Autowired
    //ImageMetadataRepository imageMetadataRepository;

    public ImageMetaData upload(MultipartFile file, String username) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        log.info("storing file {} ", filename);
        ImageMetaData imageMetaData = fileStorageService.store(file, username);

        //return imageMetadataRepository.save(imageMetaData)

        return imageMetaData;

    }

}
