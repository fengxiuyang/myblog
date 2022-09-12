package com.lee.blog.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhicheng lee
 * @date: 2022/9/12 15:55
 */

public class BeanCopyUtils {
    private BeanCopyUtils() {
    }

    /**
     * 复制对象
     */
    public static <V> V copyObject(Object source, Class<V> clazz) {
        V tmp = null;

        try {
            tmp = clazz.newInstance();
            if (null != source) {
                BeanUtils.copyProperties(source, tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tmp;
    }

    /**
     * 拷贝集合
     */
    public static <O,V> List<V> copyList(List<O> source,Class<V> clazz){
        return source.stream()
                .map(s->copyObject(s,clazz))
                .collect(Collectors.toList());
    }
}
