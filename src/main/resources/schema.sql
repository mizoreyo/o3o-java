create table if not exists t_comment
(
    id   long auto_increment,
    `key`  varchar,
    parentId  long,
    pageId  varchar,
    name  varchar,
    email varchar,
    site  varchar,
    comment     varchar(1000),
    date         long,
    constraint T_COMMENT_PK
        primary key (id)
);

create unique index if not exists T_COMMENT_ID_UINDEX
    on t_comment (id);