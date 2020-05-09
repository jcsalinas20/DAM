package objetos;

import java.util.HashMap;

import javafx.scene.control.CheckBox;

public class Cliente {

	/*************************** VARIABLES *****************************/
	
	int id;
	String nombre;
	String apellidos;
	String correo;
	int telefono;
	char sexo;
	String direccion;
	String cp;
	String provincia;
	String localidad;
	CheckBox recibirCajaEsteMes;

	public HashMap<String, Hijo> hijo = new HashMap<String, Hijo>();;

	/************************* CONSTRUCTORES ***************************/
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String apellidos, String correo, int telefono, char sexo, String direccion,
			String cp, String provincia, String localidad, CheckBox recibirCajaEsteMes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.sexo = sexo;
		this.direccion = direccion;
		this.cp = cp;
		this.provincia = provincia;
		this.localidad = localidad;
		this.recibirCajaEsteMes = recibirCajaEsteMes;
	}

	/************************ METODO TOSTRING **************************/
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", telefono=" + telefono + ", sexo=" + sexo + ", direccion=" + direccion + ", cp=" + cp
				+ ", provincia=" + provincia + ", localidad=" + localidad + ", recibirCajaEsteMes=" + recibirCajaEsteMes
				+ ", hijo=" + hijo + "]";
	}

	/********************** GETTERS AND SETTERS ************************/
	
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public CheckBox getRecibirCajaEsteMes() {
		return recibirCajaEsteMes;
	}

	public void setRecibirCajaEsteMes(CheckBox recibirCajaEsteMes) {
		this.recibirCajaEsteMes = recibirCajaEsteMes;
	}

	public HashMap<String, Hijo> getHijo() {
		return hijo;
	}

	public void setHijo(HashMap<String, Hijo> hijo) {
		this.hijo = hijo;
	}

}
