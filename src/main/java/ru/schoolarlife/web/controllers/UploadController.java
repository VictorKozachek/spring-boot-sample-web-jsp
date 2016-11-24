package ru.schoolarlife.web.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

/**
 * Created by victor on 23.11.16.
 */
@RestController
public class UploadController {
    @RequestMapping(method = RequestMethod.POST, value = "/file-upload")
    public ResponseEntity<String> upload(MultipartHttpServletRequest request) {
        return new ResponseEntity<String>(String.format("total: %d", request.getMultiFileMap().size()), HttpStatus.OK);
    }


}
