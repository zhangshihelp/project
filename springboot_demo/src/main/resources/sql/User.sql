drop table if exists tb_user;
create table tb_user(
  id bigint(20) not null auto_increment,
  user_name varchar(100) default null comment '用户名',
  password varchar(100) default null comment '密码',
  name varchar(100) default null comment '姓名',
  age int(10) default null comment '年龄',
  sex tinyint(1) default null comment '性别：1男性，2女性',
  birthday date default null comment '出生日期',
  note varchar(255) default null comment '备注',
  created datetime default null comment '创建时间',
  updated datetime default null comment '更新时间',
  primary key (id),
  unique key username (user_name)
)engine=InnoDB auto_increment=13 default charset=UTF8MB4;