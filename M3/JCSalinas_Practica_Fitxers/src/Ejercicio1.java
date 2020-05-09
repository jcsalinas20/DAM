import java.io.File;

public class Ejercicio1 {

	public static void main(String[] args) {
		File carpeta = new File("C:/IOC Programacio/Java/Fonts/Unitat 6/Temp");
		if(carpeta.exists()==true) {
			carpeta.delete();
			System.out.println("Se ha borrado la carpeta C:\\IOC Programació\\Java\\Fonts\\Unitat 6\\Temp. ");
		}else {
			carpeta.mkdirs();
			System.out.println("Se ha creado la carpeta C:\\IOC Programació\\Java\\Fonts\\Unitat 6\\Temp. ");
		}
	}

}
