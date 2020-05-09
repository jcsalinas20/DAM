package otros;

import java.time.LocalDate;

import application.FormularioCliente;
import application.FormularioHijos;
import application.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import objetos.Hijo;

public class Alerts {
	
	FormularioHijos fHijos = new FormularioHijos();

	public static void cambiosGuardados(Hijo hijo, FormularioCliente fCliente, String nombre, String apellidos, LocalDate fecha, Boolean sexoH, String talla, String pie) {
		Alert alert = new Alert(null);
		alert.setAlertType(AlertType.CONFIRMATION);
		alert.setTitle("Editor de Hijo");
		alert.setHeaderText(null);
		alert.setContentText(hijo.getNombre() + " ha sido modificado correctamente.");
		alert.showAndWait().ifPresent((btnType) -> {
			if (btnType == ButtonType.OK) {
//				Metodo para cambiar el nombre del hijo en el ListVew
				fCliente.editarNombreHijo(nombre, hijo.getNombre());

//				Agregar los parametros al Objeto Hijo
				hijo.setNombre(nombre);
				hijo.setApellidos(apellidos);
				hijo.setFecha_nacimiento(fecha);
				char sexo = '#';
				if (sexoH)
					sexo = 'H';
				else
					sexo = 'M';
				hijo.setSexo(sexo);
				hijo.setTalla(talla);
				hijo.setPies(pie);

				alert.close();// Cerrar alert
				FormularioCliente.habilitarComponentes();// Habilitar componentes
				Main.frameFormularioHijos.close();// Cerrar ventana Formulario Hijo
			}
		});
	}

	public static void noSeleccionado(String title, String context) {
		Alert alert = new Alert(null);
		alert.setAlertType(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(context);
		alert.show();
	}
	
	public static void terminarPrograma() {
		Alert alert = new Alert(null);
		alert.setAlertType(AlertType.CONFIRMATION);
		alert.setTitle("Añadir Clientes");
		alert.setHeaderText(null);
		alert.setContentText("Estas seguro de que quieres salir del programa");
		alert.showAndWait().ifPresent((btnType) -> {
			if (btnType == ButtonType.OK) {
				alert.close();
				System.exit(0);
			}
		});
	}

}
