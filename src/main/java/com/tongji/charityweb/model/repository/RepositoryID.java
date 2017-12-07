package com.tongji.charityweb.model.repository;
import java.io.Serializable;

public class RepositoryID implements Serializable {
    private String userName;
    private String repName;

    public RepositoryID() {

    }

    public RepositoryID(String userName, String repName) {
        this.userName = userName;
        this.repName = repName;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((this.userName == null) ? 0 : this.userName.hashCode());
        result = prime * result + ((this.repName == null) ? 0 : this.repName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RepositoryID other = (RepositoryID) obj;
        if(this.repName == other.getRepName() && this.userName==other.getUserName())
            return true;
        return false;
    }
}
