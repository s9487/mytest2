package com.ronghao.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
/*    `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) DEFAULT NULL,
  `password` VARCHAR(50) DEFAULT NULL,
  `name*/
  //主键
  @Id
  //主键生成策略
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /*
  *TABLE：使用一个特定的数据库表格来保存主键。
SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
IDENTITY：主键由数据库自动生成（主要是自动增长型）
AUTO：主键由程序控制。
  * */

 private  Integer id;
    @Column(name = "username")
 private  String username;

    @Column(name = "password")
 private  String password;

   @Column(name = "name")
 private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
