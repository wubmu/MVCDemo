package com.wwwyb.web.Beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 吴亚斌 on 2017/2/18.
 */
public class CustomerFormBean implements Serializable {
    private String id;
    private String name;
    private String gender;
    private String cellphone;
    private String email;
    private String type;
    private String description;
    private String birthday;
    private  String hobbies[];

    public Map<String, String> getErrors() {
        return errors;
    }
    public boolean validate(){
        //略
        return errors.isEmpty();
    }

    Map<String,String> errors= new HashMap<String ,String>();

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
