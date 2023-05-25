package S05T02N01F03GPedroTejero.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {

	@Id
	private String _id;
	
	
	private Erole name;

	public Role() {

	}
	
	public Role(Erole name) {
		this.name=name;
		
	}

	public Erole getName() {
		return name;
	}

	public void setName(Erole name) {
		this.name = name;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
}
