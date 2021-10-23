-- 用户表
create table thinkCar.t_sys_user
(
    pk_id       bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    dept_id     bigint(20) not null comment '部门ID',
    position_id bigint(20) not null comment '岗位ID',
    uin         varchar(32) comment '用户账号',
    username    varchar(32) not null comment '用户名称',
    pwd         varchar(64) not null comment '密码',
    age         int comment '年龄',
    email       varchar(64) not null comment '邮箱',
    phone       varchar(16) not null comment '电话',
    create_date datetime default CURRENT_TIMESTAMP null comment '创建时间',
    create_by   int(10) null comment '创建人ID',
    update_by   int(10) null comment '更新人ID',
    update_date datetime default CURRENT_TIMESTAMP null comment '更新时间',
    remark      varchar(2000) null comment '备注'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '用户信息表';


-- 部门表
create table thinkCar.t_sys_dept
(
    pk_id     bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    dept_name varchar(64) comment '部门名称',
    remark    varchar(1000) comment '部门描述'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '部门表';

-- 部门表
create table thinkCar.t_sys_position
(
    pk_id         bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    position_name varchar(64) comment '职位名称',
    remark        varchar(1000) comment '部门描述'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '职位表';


-- 产品基础信息
create table thinkCar.t_think_base_info
(
    pk_id         bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    think_type_id bigint(20) not null comment '产品类型ID',
    think_name    varchar(64) not null comment '产品名称',
    create_by     int(10) null comment '创建人ID',
    create_date   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by     int(10) null comment '更新人ID',
    update_date   datetime default CURRENT_TIMESTAMP null comment '更新时间',
    remark        varchar(2000) null comment '备注'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '产品基础信息表';

-- 产品类型
create table thinkCar.t_think_type
(
    pk_id      bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    think_type varchar(128) comment '产品类型',
    remark     varchar(1000) comment '部门描述'
)ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '产品类型表';-- 用户表
create table thinkCar.t_sys_user
(
    pk_id       bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    dept_id     bigint(20) not null comment '部门ID',
    position_id bigint(20) not null comment '岗位ID',
    uin         varchar(32) comment '用户账号',
    username    varchar(32) not null comment '用户名称',
    pwd         varchar(64) not null comment '密码',
    age         int comment '年龄',
    email       varchar(64) not null comment '邮箱',
    phone       varchar(16) not null comment '电话',
    create_date datetime default CURRENT_TIMESTAMP null comment '创建时间',
    create_by   int(10) null comment '创建人ID',
    update_by   int(10) null comment '更新人ID',
    update_date datetime default CURRENT_TIMESTAMP null comment '更新时间',
    remark      varchar(2000) null comment '备注'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '用户信息表';


-- 部门表
create table thinkCar.t_sys_dept
(
    pk_id     bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    dept_name varchar(64) comment '部门名称',
    remark    varchar(1000) comment '部门描述'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '部门表';

-- 部门表
create table thinkCar.t_sys_position
(
    pk_id         bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    position_name varchar(64) comment '职位名称',
    remark        varchar(1000) comment '部门描述'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '职位表';


-- 产品基础信息
create table thinkCar.t_think_base_info
(
    pk_id         bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    think_type_id bigint(20) not null comment '产品类型ID',
    think_name    varchar(64) not null comment '产品名称',
    create_by     int(10) null comment '创建人ID',
    create_date   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by     int(10) null comment '更新人ID',
    update_date   datetime default CURRENT_TIMESTAMP null comment '更新时间',
    remark        varchar(2000) null comment '备注'
) ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '产品基础信息表';

-- 产品类型
create table thinkCar.t_think_type
(
    pk_id      bigint(20) not null auto_increment COMMENT '主键Id' primary key,
    think_type varchar(128) comment '产品类型',
    remark     varchar(1000) comment '部门描述'
)ENGINE = InnoDB
default CHARSET = utf8
collate = utf8_general_ci
COMMENT = '产品类型表';