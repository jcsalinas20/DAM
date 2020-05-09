import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio2 {

	public static void main(String[] args) {
		Connection conn = Conexion.conexion();
		
		try {
			PreparedStatement pstmnt = conn.prepareStatement("UPDATE asistenciamedica SET importe = '6523.34' WHERE breveDescripcion LIKE 'Dermatitis infecciosa'");
			pstmnt.executeUpdate();
			
			System.out.println("Actualizado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
