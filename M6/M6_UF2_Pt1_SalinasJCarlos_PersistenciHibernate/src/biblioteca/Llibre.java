package biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "llibres")
public class Llibre {

	@Id
	@Column(name = "ID_llibre")
	int id;
	@Column(name = "Nomllibre")
	String nomLlibre;
	@Column(name = "Editoria")
	String editorial;
	@Column(name = "Autor")
	String autor;

	public Llibre() {
	}

	public Llibre(int id, String nomLlibre, String editorial, String autor) {
		super();
		this.id = id;
		this.nomLlibre = nomLlibre;
		this.editorial = editorial;
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomLlibre() {
		return nomLlibre;
	}

	public void setNomLlibre(String nomLlibre) {
		this.nomLlibre = nomLlibre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Llibre [id=" + id + ", nomLlibre=" + nomLlibre + ", editorial=" + editorial + ", autor=" + autor + "]";
	}

}
