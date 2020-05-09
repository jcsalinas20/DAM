import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class ArchivoDDBB {

	static File archivo = new File("becadades.dat");
	static File archivoBackup = new File("becadadesBK.dat");

//	 Metodo para comprobar que existe el archivo
	public void comprobarQueExiste() {
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();// Creaicon del archivo

				PrintStream escriptor = new PrintStream(archivo);
				escriptor.print("fi");// Se agrega fi al archivo para saber el fin del archivo
				escriptor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	 Metodo para leer el archivo y meterlos en el ArrayList
	@SuppressWarnings("deprecation")
	public ArrayList<Becari> lecturaDeFichero() {
		ArrayList<Becari> listaBecarios = new ArrayList<Becari>();// Declaracion de arraylist local

		try {
			FileInputStream fis = new FileInputStream(archivo);
			DataInputStream dis = new DataInputStream(fis);

			while (true) {
				String frase = dis.readLine();// Leer linea entera
				if (frase.equals("fi")) {
					break;
				} else {
					String componentes[] = frase.split("-");// Hacer split para separarlas en sus posiciones
					Becari b = new Becari();
					b.setNombreApellidos(componentes[0]);
					b.setSexe(componentes[1].charAt(0));// Pasar de String a char
					b.setEdad(Integer.parseInt(componentes[2]));// Pasar de String a int
					b.setNumSuspendidos(Integer.parseInt(componentes[3]));// Pasar de String a int
					b.setResicenciaFamiliar(Boolean.getBoolean(componentes[4]));// Pasar de String a boolean
					b.setIngresos(Float.valueOf(componentes[5]));// Pasar de String a float
					listaBecarios.add(b);// Agregar al arraylist local del metodo
				}
			}

			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaBecarios;// Retornar arraylist
	}

//	 Metodo para guardar el arraylist en el archivo cuando acabe el programa
	public void guardarEnArchivo(ArrayList<Becari> listaBecarios) {
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			DataOutputStream dos = new DataOutputStream(fos);

			for (int i = 0; i < listaBecarios.size(); i++) {
				dos.writeBytes(listaBecarios.get(i).toString());// Agregar al archivo directamente el toString
			}
			dos.writeBytes("fi");// Agregar fi al final del archivo

			dos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	 Metodo para crear el archivo backup
	public void crearBackUp(ArrayList<Becari> listaBecarios) {
		try {
			FileOutputStream fos = new FileOutputStream(archivoBackup);
			DataOutputStream dos = new DataOutputStream(fos);

			for (int i = 0; i < listaBecarios.size(); i++) {
				dos.writeBytes(listaBecarios.get(i).toString());// Agregar al archivo backup directamente el toString
			}

			dos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
