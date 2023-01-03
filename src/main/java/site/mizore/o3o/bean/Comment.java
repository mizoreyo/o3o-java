package site.mizore.o3o.bean;

import lombok.Data;

@Data
public class Comment {

    private Long id;
    private String key;
    private Long parentId;
    private String pageId;
    private String name;
    private String email;
    private String site;
    private String comment;
    private Long date;

}
