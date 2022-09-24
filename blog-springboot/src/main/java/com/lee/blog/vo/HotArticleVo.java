package com.lee.blog.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 热门文章
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    private Long id;
    //标题
    private String title;

    //访问量
    private Long viewCount;
}
