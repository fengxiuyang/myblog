package com.lee.blog.controller;

import com.lee.blog.service.UploadService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传
 *
 * @author: zhicheng lee
 * @date: 2022/9/25 21:20
 */

@RestController
// @RequestMapping
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * 上传图片
     */
    @PostMapping("/upload")
    public ResponseResult uploadImage(MultipartFile img) {
        return uploadService.uploadImage(img);
    }

}
