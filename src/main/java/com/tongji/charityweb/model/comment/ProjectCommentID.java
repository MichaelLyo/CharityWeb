package com.tongji.charityweb.model.comment;
import java.io.Serializable;

public class ProjectCommentID implements Serializable {
    private String projName;
    private String repName;
    private int num;
    private String userName;

    public ProjectCommentID() {
    }


    public ProjectCommentID(String projName, String repName, String userName, int num) {
        this.projName = projName;
        this.repName = repName;
        this.num = num;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectCommentID that = (ProjectCommentID) o;

        if (num != that.num) return false;
        if (projName != null ? !projName.equals(that.projName) : that.projName != null) return false;
        return repName != null ? repName.equals(that.repName) : that.repName == null;
    }

    @Override
    public int hashCode() {
        int result = projName != null ? projName.hashCode() : 0;
        result = 31 * result + (repName != null ? repName.hashCode() : 0);
        result = 31 * result + num;
        return result;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
