package biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@Column(name = "DNI")
	int dni;
	@Column(name = "Nompersona")
	String nomPersona;
	@Column(name = "Telefon")
	int telefon;

	public Persona() {
	}

	public Persona(int dni, String nomPersona, int telefon) {
		super();
		this.dni = dni;
		this.nomPersona = nomPersona;
		this.telefon = telefon;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNomPersona() {
		return nomPersona;
	}

	public void setNomPersona(String nomPersona) {
		this.nomPersona = nomPersona;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nomPersona=" + nomPersona + ", telefon=" + telefon + "]";
	}
}
