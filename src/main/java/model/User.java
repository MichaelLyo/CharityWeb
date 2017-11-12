package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private String userName;
    private String password;
	private int id;
    public User(String username, String password) {
        super();
        this.userName = username;
        this.password = password;
    }
    public User()
    {

    }


	@Basic
	@Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Id
	@Column(name = "id")
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}