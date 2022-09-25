package com.lee.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 路径生成工具
 *
 * @author: zhicheng lee
 * @date: 2022/9/25 21:46
 */

public class PathUtils {

    public static String generateFilePath(String fileName) {
        // 根据日期生成路径
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dataPath = sdf.format(new Date());

        // uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        // 后缀和文件后缀一致
        int index = fileName.lastIndexOf(".");
        String fileType = fileName.substring(index);

        return new StringBuilder().append(dataPath).append(uuid).append(fileType).toString();
    }
}
