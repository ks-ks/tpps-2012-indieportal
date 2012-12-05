package domain;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public abstract class Text extends DomainObject{
	
	@NotNull
	User creator;
	@NotNull
	Date dateOfCreation;
	@NotNull
	Date dateOfModification;
	@NotEmpty
	String text;
	@NotEmpty 
	Integer rating;
	
	protected Text(){
		this.dateOfCreation = new Date();
		this.dateOfModification = new Date();
		this.rating = 0;
	}
	public Text(String text, User creator){
		this.text = text;
		this.creator = creator;
		this.dateOfCreation = new Date();
		this.dateOfModification = new Date();
		this.rating = 0;
	}
	
	protected void setRating(Integer rating){
		this.rating = rating;
	};
	public Integer getRating(){
		return rating;
	};

	protected void setCreator(User creator){
		this.creator = creator;
	};
	
	public User getCreator(){
		return creator;
	};
	
	protected void setDateOfCreation(Date dateOfCreation){
		this.dateOfCreation = dateOfCreation;
	};
	
	public Date getDateOfCreation(){
		return dateOfCreation;
	};
	
	public Date getDateOfModification(){
		return dateOfModification;
	};
	
	protected void setText(String text){
		this.text = text;
		this.dateOfModification = new Date(); // now;
	};
	
	public String getText(){
		return text;
	};
	
}
