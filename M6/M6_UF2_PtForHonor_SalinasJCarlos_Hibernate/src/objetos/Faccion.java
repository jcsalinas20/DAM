package objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faccion")
public class Faccion {

	@Id
	@Column(name = "faccion_id")
	int id;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "lore")
	String lore;

	public Faccion() {
	}

	public Faccion(int id, String nombre, String lore) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lore = lore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	@Override
	public String toString() {
		return "Faccion [id=" + id + ", nombre=" + nombre + ", lore=" + lore + "]";
	}

}
