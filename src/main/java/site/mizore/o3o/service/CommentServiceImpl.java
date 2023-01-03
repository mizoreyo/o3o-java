package site.mizore.o3o.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mizore.o3o.bean.Comment;
import site.mizore.o3o.bean.CommentNode;
import site.mizore.o3o.bean.CommentVo;
import site.mizore.o3o.dao.CommentDao;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentDao commentDao;
    
    @Override
    public int addComment(CommentVo commentVo) {
        Comment comment=new Comment();
        BeanUtils.copyProperties(commentVo,comment);
        comment.setDate(new Date().getTime());
        return commentDao.add(comment);
    }

    @Override
    public List<CommentNode> getCommentTree(String key, String pageId) {
        List<Comment> comments = commentDao.getListByKeyAndPage(key, pageId);
        CommentNode root=new CommentNode();
        root.setId(0L);
        treeify(root,comments);
        return root.getChildren();
    }
    
    private void treeify(CommentNode node,List<Comment> comments) {
        List<CommentNode> children = comments.stream().filter(comment -> Objects.equals(node.getId(),
                comment.getParentId())).map(comment -> {
            CommentNode commentNode=new CommentNode();
            BeanUtils.copyProperties(comment,commentNode);
            treeify(commentNode,comments);
            return commentNode;
        }).collect(Collectors.toList());
        node.setChildren(children);
    }
}
