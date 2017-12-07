package com.tongji.charityweb.model.project;
import java.io.Serializable;

public class ProjectID implements Serializable {
    private String userName;
    private String repName;
    private String projName;

    public ProjectID() {

    }

    public ProjectID(String projName ,String repName, String userName) {
        this.userName = userName;
        this.repName = repName;
        this.projName = projName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectID projectID = (ProjectID) o;

        if (userName != null ? !userName.equals(projectID.userName) : projectID.userName != null) return false;
        if (repName != null ? !repName.equals(projectID.repName) : projectID.repName != null) return false;
        return projName != null ? projName.equals(projectID.projName) : projectID.projName == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (repName != null ? repName.hashCode() : 0);
        result = 31 * result + (projName != null ? projName.hashCode() : 0);
        return result;
    }
}

