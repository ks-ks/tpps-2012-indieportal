package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id = null;
	
	public DomainObject() {
		id = null;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
