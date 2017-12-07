package com.tongji.charityweb.model.comment;
import java.io.Serializable;

public class RepositoryCommentID implements Serializable{
    private int num;
    private String repName;
    private String userName;

    public RepositoryCommentID() {
    }

    public RepositoryCommentID(int num, String repName, String userName) {
        this.num = num;
        this.repName = repName;
        this.userName = userName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepositoryCommentID that = (RepositoryCommentID) o;

        if (num != that.num) return false;
        if (repName != null ? !repName.equals(that.repName) : that.repName != null) return false;
        return userName != null ? userName.equals(that.userName) : that.userName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (num ^ (num >>> 32));
        result = 31 * result + (repName != null ? repName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
