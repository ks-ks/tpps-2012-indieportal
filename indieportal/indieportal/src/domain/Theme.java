package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Theme extends Message{

	Collection<Message> comments;
	int position;
	long summary; 
		
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
		setRating(getRating() +1);
	};
	
	public void decreaseRatingOfTheme(){
		setRating(getRating() +1);
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
