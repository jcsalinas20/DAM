package comandos;

public class Tractament {
	public static final String MARCA_FI = "fi";

	public static void main(String[] args) {
		Tractament programa = new Tractament();
		programa.inici();
	}

	public void inici() {
		System.out.println("Scanner lector = new Scanner(lectura)\n");
		System.out.println("PrintStream escriptor = new PrintStream(escriptura)");
	}

}