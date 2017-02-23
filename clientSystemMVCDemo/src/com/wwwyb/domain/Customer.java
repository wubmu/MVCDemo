package com.wwwyb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 Create table customer(
    id varchar(100) primary key,
    name varchar(100),
    gender varchar(100),
    birthday date,
    cellphone varchar(100),
    email varchar(100),
    type varchar(100),#普通客户,VIP客户
    description varchar(255)
 );
 */

/**
 * Created by 吴亚斌 on 2017/2/14.
 */
public class Customer implements Serializable {
    private String id;
    private String name;
    private String gender;
    private String cellphone;
    private String email;
    private String type;
    private String description;
    private Date birthday;
    private  String hobby;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", birthday=" + birthday +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Customer() {
    }

    public Customer(String id, String name, String gender,Date birthday,String cellphone,String email,String hobby,String type,String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.cellphone = cellphone;
        this.email = email;
        this.type = type;
        this.description = description;
        this.birthday = birthday;
        this.hobby=hobby;
    }
}
