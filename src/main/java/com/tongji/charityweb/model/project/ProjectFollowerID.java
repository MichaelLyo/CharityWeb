package com.tongji.charityweb.model.project;

import java.io.Serializable;

public class ProjectFollowerID implements Serializable {
    private String userName;
    private String repName;
    private String projName;
    private String followerName;

    public ProjectFollowerID() {
    }

    public ProjectFollowerID(String userName, String repName, String projName, String followerName) {
        this.userName = userName;
        this.repName = repName;
        this.projName = projName;
        this.followerName = followerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getFollowerName() {
        return followerName;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }
}
