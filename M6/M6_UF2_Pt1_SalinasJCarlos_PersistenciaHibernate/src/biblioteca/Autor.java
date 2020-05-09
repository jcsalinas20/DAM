package biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@Column(name = "ID_autor")
	int id;
	@Column(name = "Nomautor")
	String nomAutor;

	public Autor() {
	}

	public Autor(int id, String nomAutor) {
		super();
		this.id = id;
		this.nomAutor = nomAutor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAutor() {
		return nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

}
