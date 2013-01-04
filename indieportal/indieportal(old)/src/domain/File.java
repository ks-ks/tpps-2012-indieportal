package domain;


public class File {
	public enum FileType {Image, Video, Executable} 
	public String name;
	public FileType type;
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
