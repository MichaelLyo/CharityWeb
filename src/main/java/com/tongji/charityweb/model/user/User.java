package com.tongji.charityweb.model.user;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    // columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String sex;

    @NotNull
    private String rank;

    private String address;

    private String phone;

    private String hpPictureUrl;

    private String introduction;

    private String description;




    // Public methods

    //Constructors
    public User() { }

    public User(String email, String name)
    {
        this.email = email;
        this.name = name;
    }

    public User(String email, String name, String password, String sex, String rank)
    {
        this.email = email;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.rank = rank;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getAddress()
    {
        return address;
    }

    public String getDescription()
    {
        return description;
    }

    public String getHpPictureUrl()
    {
        return hpPictureUrl;
    }

    public String getIntroduction()
    {
        return introduction;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getRank()
    {
        return rank;
    }

    public String getSex()
    {
        return sex;
    }


    //setters
    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setHpPictureUrl(String hpPictureUrl)
    {
        this.hpPictureUrl = hpPictureUrl;
    }

    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

}
