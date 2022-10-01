package com.lee.blog.controller;

import com.lee.blog.entity.Link;
import com.lee.blog.service.LinkService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhicheng lee
 * @date: 2022/9/25 14:48
 */

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 查询所有友链
     */
    @GetMapping("/getAllLink")
    public ResponseResult getAllLink() {
        return linkService.getAllLink();
    }

    /**
     * 新增友链
     */
    @PostMapping
    public ResponseResult add(@RequestBody Link link) {
        linkService.save(link);
        return ResponseResult.okResult();
    }

    /**
     * 删除友链
     */
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id) {
        linkService.removeById(id);
        return ResponseResult.okResult();
    }

    /**
     * 编辑友链
     */
    @PutMapping
    public ResponseResult edit(@RequestBody Link link) {
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    /**
     * 查询友链
     */
    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id") Long id) {
        Link link = linkService.getById(id);
        return ResponseResult.okResult(link);
    }
}

