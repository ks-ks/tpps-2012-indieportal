package domain;

import java.util.Collection;
import java.util.Date;

public class User extends DomainObject{
	public enum Role {Guest,User,Moderator,Administrator,Developer}
	public String login;
	public String name;
	public String password;
	public Date dateOfRegistration;
	public Date dateOfLastVisit;
	public Role role;

	public Collection<Message> messages;
	public Collection<Theme> themes; 

	
	public boolean checkPassword (String password){
		return this.password.equals(password);
	}
	public void setRole(Role role){
		this.role = role;
	};

	public Role getRole(){
		return role;
	};
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public Date getDateOfLastVisit() {
		return dateOfLastVisit;
	}

	public void setDateOfLastVisit(Date dateOfLastVisit) {
		this.dateOfLastVisit = dateOfLastVisit;
	}


}
