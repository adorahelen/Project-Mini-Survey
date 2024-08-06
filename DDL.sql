CREATE DATABASE JDBC;

USE JDBC;

CREATE TABLE t_member (
    mid VARCHAR(20) PRIMARY KEY,
    mname VARCHAR(45),
    mpw VARCHAR(45),
    email VARCHAR(45),
    gender CHAR(1),
    photo VARCHAR(45),
    birth_date DATE,
    join_date DATE
);

CREATE TABLE t_survey (
    survey_no INT PRIMARY KEY,
    title VARCHAR(100),
    one VARCHAR(500),
    two VARCHAR(500),
    one_cnt INT,
    two_cnt INT,
    start_date DATE,
    end_date DATE,
    reg_date DATE,
    mod_date DATE
);

CREATE TABLE t_vote (
    survey_no INT,
    id VARCHAR(20),
    one_two INT,
    vote_date DATE,
    PRIMARY KEY (survey_no, id),
    FOREIGN KEY (survey_no) REFERENCES t_survey(survey_no),
    FOREIGN KEY (id) REFERENCES t_member(mid)
);