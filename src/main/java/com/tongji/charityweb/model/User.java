package com.tongji.charityweb.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {

    // columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String sex;

    private String address;

    private String phone;

    private String hpPictureUrl;

    private String introduction;

    private String description;

    @NotNull
    private String rank;


    // Public methods

    public User() { }

    public User(String email, String name)
    {
        this.email = email;
        this.name = name;
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
