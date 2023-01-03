package site.mizore.o3o.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.mizore.o3o.bean.Comment;
import site.mizore.o3o.bean.CommentNode;
import site.mizore.o3o.bean.CommentVo;
import site.mizore.o3o.common.CommonResult;
import site.mizore.o3o.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommonResult<Boolean> add(@RequestBody CommentVo commentVo) {
        int result=commentService.addComment(commentVo);
        if(result>0) {
            return CommonResult.success(true);
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping
    public CommonResult<List<CommentNode>> tree(@RequestParam("key") String key,
                                                @RequestParam("pageId") String pageId) {
        return CommonResult.success(commentService.getCommentTree(key,pageId));
    }

}
