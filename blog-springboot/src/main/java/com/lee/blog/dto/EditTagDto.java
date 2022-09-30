package com.lee.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 编辑标签
 * @author: zhicheng lee
 * @date: 2022/9/30 19:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTagDto {

    private Long id;
    //备注
    private String remark;
    //标签名
    private String name;
}
