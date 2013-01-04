package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name= "Theme.getBySection", query= "SELECT c FROM Theme c WHERE c.section.id = ?1"),
	@NamedQuery(name = "Theme.deleteAllBySection", query = "DELETE FROM Theme c WHERE c.section.id = ?1")
})
public class Theme extends Message{
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "creator", referencedColumnName = "id")
	User creator;

	@OneToMany(mappedBy = "theme")
	Collection<Message> comments;
	
	@NotEmpty
	int position;
	@NotNull
	Long summary; 
	@NotNull
	@ManyToOne
	Section section;

	public Theme(){
		
	}
	
	protected void setCreator(User creator){
		this.creator = creator;
	};
	
	public User getCreator(){
		return creator;
	};
	
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Theme(String title, User  user){
		super(title, user);
		comments = new ArrayList<Message>();
	}
	public void addComment(Message comment){
		comments.add(comment);
	};

	public void deleteComment(Message comment){
		this.comments.remove(comment);
	};
	public Collection<Message> getComments(){
		return comments;
	}
	public void setTitle(String title){
		setText(title);
	};
	public String getTitle(){
		return text;
	}
	public void increaseRatingOfTheme(){
		setRating(getRating() +1l);
	};
	
	public void decreaseRatingOfTheme(){
		setRating(getRating() +1l);
	}
	public long calculateSummary() {
		summary = 1000l + rating;
		for (Iterator<Message> i=comments.iterator(); i.hasNext();){
			summary += i.next().rating;
		}
		
		return summary;
	}
	public Long getSummary() {
		return summary;
	};
}
