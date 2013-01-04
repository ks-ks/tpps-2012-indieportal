package domain;


import java.util.ArrayList;
import java.util.Collection;

public class Message extends Text{
	
	Collection<File> files;
	
	public Message() {
		files = new ArrayList<File>();
	}
	
	public Message(String text,User user){
		super(text,user);
		files = new ArrayList<File>();
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
