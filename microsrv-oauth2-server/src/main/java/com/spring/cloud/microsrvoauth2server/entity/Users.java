package com.spring.cloud.microsrvoauth2server.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ author      ：ytzhou
 * @ date        ：13:13 2018/9/19
 * @ description ：${description}
 * @ version:    ：v1.0
 */
@Entity
@Table(name = "users", schema = "oauth2", catalog = "")
public class Users {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private Date birthday;
    private Integer sex;
    private String avatar;
    private String mobile;
    private String email;
    private Integer status;
    private Timestamp lastSigninTime;
    private Timestamp lastSignoutTime;
    private Timestamp updateAt;
    private Timestamp createAt;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "last_signin_time")
    public Timestamp getLastSigninTime() {
        return lastSigninTime;
    }

    public void setLastSigninTime(Timestamp lastSigninTime) {
        this.lastSigninTime = lastSigninTime;
    }

    @Basic
    @Column(name = "last_signout_time")
    public Timestamp getLastSignoutTime() {
        return lastSignoutTime;
    }

    public void setLastSignoutTime(Timestamp lastSignoutTime) {
        this.lastSignoutTime = lastSignoutTime;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "create_at")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) &&
                Objects.equals(username, users.username) &&
                Objects.equals(nickname, users.nickname) &&
                Objects.equals(password, users.password) &&
                Objects.equals(birthday, users.birthday) &&
                Objects.equals(sex, users.sex) &&
                Objects.equals(avatar, users.avatar) &&
                Objects.equals(mobile, users.mobile) &&
                Objects.equals(email, users.email) &&
                Objects.equals(status, users.status) &&
                Objects.equals(lastSigninTime, users.lastSigninTime) &&
                Objects.equals(lastSignoutTime, users.lastSignoutTime) &&
                Objects.equals(updateAt, users.updateAt) &&
                Objects.equals(createAt, users.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, nickname, password, birthday, sex, avatar, mobile, email, status, lastSigninTime, lastSignoutTime, updateAt, createAt);
    }
}