package com.tongji.charityweb.model.user;


import com.tongji.charityweb.model.repository.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "User",uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {

    // columns
    @Id
    private String username;

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

    private String nickname;

    private String address;

    private String phone;

    private String hpPictureUrl;

    private String introduction;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private List<Donate> donates;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="username",referencedColumnName = "username")
    private List<UserFollower> followers;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private List<Repository>repositories;


    // Public methods

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Repository> getRepositories() {
        return repositories;
    }

    public List<Donate> getDonate()
    {
        return donates;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    //Constructors




    public List<UserFollower>getFollowers()
    {
        return followers;
    }

    public User() { }


    public User(String email, String username)
    {
        this.email = email;
        this.username = username;
    }

    public User(String email, String userName,String name, String password, String sex, String rank)
    {
        this.email = email;
        this.username = userName;
        this.password = password;
        this.sex = sex;
        this.rank = rank;
        this.name=name;
    }

    //getters


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

    public String getNickname()
    {
        return nickname;
    }

    //setters

    public void setEmail(String email) {
        this.email = email;
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

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
}
