package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Generated 04-ene-2020 1:44:06 by Hibernate Tools 5.4.7.Final

/**
 * Alumno generated by hbm2java
 */
@Entity
@Table(name = "alumno")
public class Alumno implements java.io.Serializable {

	@Id
	@Column(name = "Id_Alumno")
	private int idAlumno;
	@Column(name = "Id_Grupo")
	private Grupo grupo;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Escuela")
	private String escuela;

	public Alumno() {
	}

	public Alumno(int idAlumno, Grupo grupo, String nombre, String escuela) {
		this.idAlumno = idAlumno;
		this.grupo = grupo;
		this.nombre = nombre;
		this.escuela = escuela;
	}

	public int getIdAlumno() {
		return this.idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEscuela() {
		return this.escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

}