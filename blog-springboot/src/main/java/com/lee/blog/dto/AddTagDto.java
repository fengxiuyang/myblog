package com.lee.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增标签
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 23:05
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTagDto {
    //备注
    private String remark;
    //标签名
    private String name;
}
