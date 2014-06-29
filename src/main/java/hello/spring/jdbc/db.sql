DROP TABLE IF EXISTS d_user;
CREATE TABLE d_user (
    id int(32) NOT NULL auto_increment,
    email varchar(50) NOT NULL,
    name varchar(50) default NULL,
    password varchar(50) NOT NULL,
    lastLoginTime date ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;