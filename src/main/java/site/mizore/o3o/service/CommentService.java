package site.mizore.o3o.service;

import site.mizore.o3o.bean.Comment;
import site.mizore.o3o.bean.CommentNode;
import site.mizore.o3o.bean.CommentVo;

import java.util.List;

public interface CommentService {

    int addComment(CommentVo commentVo);
    List<CommentNode> getCommentTree(String key,String pageId);

}
