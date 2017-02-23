package com.wwwyb.domain;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 吴亚斌 on 2017/2/2.
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String email;


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Date birthday;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    }

