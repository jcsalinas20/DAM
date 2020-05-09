
public class Main {

	public static void main(String[] args) {
		ConexionAPI.conexion();
		new SampleSearchItemsApi("informatica");
		new SampleSearchItemsApi("ropa");
	}

}
