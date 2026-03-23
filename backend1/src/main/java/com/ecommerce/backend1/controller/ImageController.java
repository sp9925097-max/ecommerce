package com.ecommerce.backend1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file")MultipartFile file) throws IOException{
        File directory = new File(UPLOAD_DIR);
        if(!directory.exists()){
            directory.mkdirs();
        }
        String filePath = UPLOAD_DIR + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        return "file uploaded:" + filePath;
    }
}
