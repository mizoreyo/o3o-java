package site.mizore.o3o.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mizore.o3o.bean.Comment;

import java.util.Date;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Comment comment) {
        String sql="insert into t_comment (`key`,parentId,pageId,name,email,site,comment,date) values " +
                "(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,comment.getKey(),comment.getParentId(),comment.getPageId(),comment.getName(),
                comment.getEmail(),comment.getSite(),comment.getComment(),comment.getDate());
    }

    @Override
    public List<Comment> getListByKeyAndPage(String key, String pageId) {
        String sql="select id,`key`,parentId,pageId,name,email,site,comment,date from t_comment where `key`=? and pageId=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),key,pageId);
    }
}
