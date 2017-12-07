package com.tongji.charityweb.model.user;


import com.tongji.charityweb.model.repository.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy="donator")
    private List<Donate> donates;


    @OneToMany(cascade = CascadeType.ALL,mappedBy="owner")
    private List<UserFollower> followers;


    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    private List<Repository>repositories ;


    // Public methods



    //Constructors
    public User()
    {

    }
    public User( String username)
    {
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

    public String getUsername() {
        return username;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void addRepository(Repository repository) {
        this.repositories.add(repository);
        if(repository.getUser() != this){
            repository.setUser(this);
        }
    }


    public boolean deleteRepository(Repository repository) {
        if(this.repositories.contains(repository))
        {
            this.repositories.remove(repository);
            return true;
        }
        return false;
    }

    public void addFollower(UserFollower follower) {
        this.followers.add(follower);
        if(follower.getOwner() != this){
            follower.setOwner(this);
        }
    }

    public boolean deleteFollower(UserFollower follower) {
        if(this.followers.contains(follower))
        {
            this.followers.remove(follower);
            return true;
        }
        return false;
    }

    public void addDonate(Donate donate) {
        this.donates.add(donate);
        if( donate.getDonator() != this){
            donate.setDonator(this);
        }
    }


    public boolean deleteDonate(Donate donate){
        if(this.donates.contains(donate)){
            this.donates.remove(donate);
            return true;
        }
        return false;
    }


    public List<Donate> getDonates() {
        return donates;
    }

    public List<UserFollower>getFollowers()
    {
        return followers;
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


    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }
}
