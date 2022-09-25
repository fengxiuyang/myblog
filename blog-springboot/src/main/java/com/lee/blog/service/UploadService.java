package com.lee.blog.service;

import com.lee.blog.vo.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传
 *
 * @author: zhicheng lee
 * @date: 2022/9/25 16:32
 */

public interface UploadService {
    ResponseResult uploadImage(MultipartFile img);
}
