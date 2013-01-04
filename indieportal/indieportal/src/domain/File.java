package domain;


import static javax.persistence.EnumType.STRING;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class File extends DomainObject{
	
	public enum FileType {Image, Video, Executable} 
	@NotEmpty
	String name;
	@Enumerated(STRING)
	@NotNull(message = "User role cannot be null")
	FileType type;

	@ManyToOne
	@JoinColumn(name = "owner", referencedColumnName = "id")
	Message owner;
	
	public File() {
		
	}


	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public File(String name) {
		this.name = name;
	}

	public File(String name, FileType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
}
