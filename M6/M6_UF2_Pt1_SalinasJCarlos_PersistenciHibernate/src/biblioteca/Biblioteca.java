package biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

	@Id
	@Column(name = "ID_biblioteca")
	int id;
	@Column(name = "Nom")
	String nom;

	public Biblioteca() {
	}

	public Biblioteca(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Biblioteca [id=" + id + ", nom=" + nom + "]";
	}

}
