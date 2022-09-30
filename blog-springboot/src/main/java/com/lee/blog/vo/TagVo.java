package com.lee.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhicheng lee
 * @date: 2022/9/30 20:01
 */

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVo {
    private Long id;
    //标签名
    private String name;

}
