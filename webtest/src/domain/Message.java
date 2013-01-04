package domain;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name= "Theme.getByTheme", query= "SELECT c FROM Message c WHERE c.theme.id = ?1"),
	@NamedQuery(name = "Theme.deleteAllByTheme", query = "DELETE FROM Message c WHERE c.theme.id = ?1")
})
public class Message extends Text{
	
	@NotNull
	@ManyToOne
	User creator;
	
	@NotNull
	@ManyToOne
	Theme theme;

	@OneToMany
	Collection<File> files;
	
	public Message() {
		files = new ArrayList<File>();
	}
	
	public Message(String text,User user){
		super(text,user);
		files = new ArrayList<File>();
	}
	
	protected void setCreator(User creator){
		this.creator = creator;
	};
	
	public User getCreator(){
		return creator;
	};
	
	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public void addFile(File file){
		files.add(file);
	};

	public void deleteFile(File file){
		files.remove(file);
	};
	
	public Integer getNumberOfFiles(){
		return files.size();
	};
	
	
	
	public void increaseRating(){
		setRating(getRating() + 1);
	};
	
	public void decreaseRating(){
		setRating(getRating() - 1);
	}

	public  Collection<File> getFiles() {
		return files;
	};
	
}
