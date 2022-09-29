package com.lee.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签列表
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 22:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagListDto {

    private String name;
    private String remark;
}
