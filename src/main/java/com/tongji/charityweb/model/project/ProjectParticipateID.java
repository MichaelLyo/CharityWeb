package com.tongji.charityweb.model.project;
import java.io.Serializable;

public class ProjectParticipateID implements Serializable{
    private String userName;
    private String repName;
    private String projName;
    private String parName;

    public ProjectParticipateID() {

    }

    public ProjectParticipateID(String userName, String repName, String projName, String parName) {
        this.userName = userName;
        this.repName = repName;
        this.projName = projName;

        this.parName = parName;
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

    public String getParName() {
        return parName;
    }



    public void setParName(String parName) {
        this.parName = parName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectParticipateID that = (ProjectParticipateID) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (repName != null ? !repName.equals(that.repName) : that.repName != null) return false;
        if (projName != null ? !projName.equals(that.projName) : that.projName != null) return false;
        return parName != null ? parName.equals(that.parName) : that.parName == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (repName != null ? repName.hashCode() : 0);
        result = 31 * result + (projName != null ? projName.hashCode() : 0);
        result = 31 * result + (parName != null ? parName.hashCode() : 0);
        return result;
    }
}
