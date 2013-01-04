package domain;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import javax.persistence.Basic;

@Entity
public class User extends DomainObject{
	
	public enum Role {Guest,User,Moderator,Administrator,Developer}
	
	@NotEmpty
	String login;
	@NotEmpty
	String name;
	@NotEmpty
	String password;
	@NotNull
	Date dateOfRegistration;
	@NotNull
	@Basic(optional = false)
	Date dateOfLastVisit;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "User role cannot be null")
	Role role;
	@NotNull
	Long rating;
	
	//@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "creator")
	Collection<Message> messages;
	//@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "creator")
	Collection<Theme> themes; 

	
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

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
    public void setRating(Long rating){
        this.rating = rating;
    };
    public Long getRating(){
        return rating;
    };

    public void calculateRating() {
        this.rating = 0l;

        for (Iterator<Message> i=messages.iterator(); i.hasNext();){
            this.rating += i.next().rating;
        }

        for (Iterator<Theme> i=themes.iterator(); i.hasNext();){
            this.rating += i.next().rating;
        }

    }

}
