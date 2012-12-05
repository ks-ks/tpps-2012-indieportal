package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DomainObject {
	
	@Id
	@GeneratedValue
	Long id;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
