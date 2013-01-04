package domain;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import domain.DomainObject;
import domain.User;

@Entity
public abstract class Text extends DomainObject{
	
	@NotNull

	User creator;
	@NotNull

	Date dateOfCreation;
	@NotNull
	Date dateOfModification;
	@NotEmpty
	protected String text;

	@NotEmpty
	protected 
	Long rating;

	
	protected Text(){
		this.dateOfCreation = new Date();
		this.dateOfModification = new Date();
		this.rating = 0l;
	}
	public Text(String text, User creator){
		this.text = text;
		this.dateOfCreation = new Date();
		this.dateOfModification = new Date();
		this.rating = 0l;
	}
	
	protected void setRating(long rating){
		this.rating = rating;
	};
	public long getRating(){
		return rating;
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
