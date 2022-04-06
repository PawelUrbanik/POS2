drop table if exists DISCRIMINANT cascade;
CREATE TABLE DISCRIMINANT(
                             id int primary key auto_increment,
                             shortcut varchar(4) not null,
                             description varchar(255) not null
);
drop table if exists LINE cascade;
create table LINE
(
    ID          BIGINT  not null primary key auto_increment,
    END_KM      DOUBLE,
    LINE_NAME   VARCHAR(255),
    LINE_NUMBER INTEGER not null,
    START_KM    DOUBLE
);
drop table if exists LOADING_POINT cascade;
create table LOADING_POINT
(
    ID                         BIGINT  not null primary key auto_increment,
    NAME                       VARCHAR(255),
    OPEN_FROM                  TIME,
    OPEN_TO                    TIME,
    ROUND_THE_CLOCK            BOOLEAN not null,
    OPERATING_CONTROL_POINT_ID BIGINT
);
drop table if exists RAILWAY_DEPARTMENT cascade;
create table RAILWAY_DEPARTMENT
(
    ID   BIGINT not null primary key auto_increment,
    NAME VARCHAR(255)
);
drop table if exists OPERATING_CONTROL_POINT cascade ;
create table OPERATING_CONTROL_POINT
(
    ID                    BIGINT not null primary key auto_increment,
    POINT_NAME            VARCHAR(255),
    DISCRIMINANT_ID       BIGINT,
    LINE_ID               BIGINT,
    LOADING_POINT_ID      BIGINT,
    RAILWAY_DEPARTMENT_ID BIGINT
);
drop table if exists PLATFORM cascade ;
create table PLATFORM
(
    ID                         BIGINT  not null primary key auto_increment,
    HEIGHT                     DOUBLE,
    LENGTH                     DOUBLE,
    PLATFORM_NUMBER            INTEGER,
    REQUEST_STOP               BOOLEAN not null,
    OPERATING_CONTROL_POINT_ID BIGINT
);
drop table if exists EDGE cascade;
create table EDGE
(
    ID          BIGINT not null primary key auto_increment,
    EGDE_NAME   VARCHAR(255),
    PLATFORM_ID BIGINT
);
drop  table if exists TRACK cascade;
create table TRACK
(
    ID           BIGINT not null primary key auto_increment,
    AXIS_KM      DOUBLE,
    TRACK_NUMBER INTEGER,
    EDGE_ID      BIGINT not null
);
