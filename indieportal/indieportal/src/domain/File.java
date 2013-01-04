package domain;



import javax.persistence.Entity;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class File extends DomainObject{
	
	public enum FileType {Image, Video, Executable} 
	@NotEmpty
	String name;
	
	@NotNull
	FileType type;

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
