package site.mizore.o3o.dao;

import site.mizore.o3o.bean.Comment;

import java.util.List;

public interface CommentDao {

    int add(Comment comment);
    List<Comment> getListByKeyAndPage(String key,String pageId);
}
