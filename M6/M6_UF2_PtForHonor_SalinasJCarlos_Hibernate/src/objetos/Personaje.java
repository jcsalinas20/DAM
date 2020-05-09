package objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personaje")
public class Personaje {

	@Id
	@Column(name = "personaje_id")
	int personaje_id;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "ataque")
	int ataque;
	@Column(name = "defensa")
	int defensa;
	@Column(name = "faccion_id")
	int faccion_id;

	public Personaje() {
	}

	public Personaje(int personaje_id, String nombre, int ataque, int defensa, int faccion_id) {
		super();
		this.personaje_id = personaje_id;
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.faccion_id = faccion_id;
	}

	public int getPersonaje_id() {
		return personaje_id;
	}

	public void setPersonaje_id(int personaje_id) {
		this.personaje_id = personaje_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getFaccion_id() {
		return faccion_id;
	}

	public void setFaccion_id(int faccion_id) {
		this.faccion_id = faccion_id;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + personaje_id + ", nombre=" + nombre + ", ataque=" + ataque + ", defensa=" + defensa
				+ ", faccion_id=" + faccion_id + "]";
	}
}
