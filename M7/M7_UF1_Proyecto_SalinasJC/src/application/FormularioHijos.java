package application;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.net.URL;
import java.util.ResourceBundle;

import css.EstilosCSS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.WindowEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import objetos.Hijo;
import otros.Alerts;

public class FormularioHijos implements Initializable {

	/************************* VARIABLES FXML **************************/

	@FXML
	Label lblNombrePadre;

	@FXML
	Label lblErrorComboBox;

	@FXML
	TextField tfNombre;

	@FXML
	TextField tfApellidos;

	@FXML
	RadioButton btnSexoH;

	@FXML
	RadioButton btnSexoM;

	@FXML
	DatePicker fechaNacimiento;

	@FXML
	ComboBox<String> cbTallas;

	@FXML
	ComboBox<String> cbPies;

	@FXML
	Button btnAgregar;

	@FXML
	Button btnQuitar;

	/**************************** VARIABLES ****************************/

	Main main = new Main();
	FormularioCliente fCliente = new FormularioCliente();

	public static boolean editarHijo = false;// Boolean para saber si se edita o se agrega
	public static String editarHijoConNombre;// Nombre del hijo que se edita
	Hijo hijo;

	boolean[] errorEnElContenido = { false, false };

	ObservableList<String> tallas = FXCollections.observableArrayList("0-6 meses", "6-12 meses", "1-2 a\u00f1os",
			"2-3 a\u00f1os", "3-4 a\u00f1os", "4-5 a\u00f1os", "5-6 a\u00f1os", "6-7 a\u00f1os", "7-8 a\u00f1os",
			"8-9 a\u00f1os", "9-10 a\u00f1os");// Opciones ComboBox cbTallas
	ObservableList<String> pies = FXCollections.observableArrayList();// Opciones ComboBox cbPies

	/************************ METODO INITIALIZE ************************/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Point cursor = MouseInfo.getPointerInfo().getLocation();// Sacar la posicion del raton
			if (FormularioCliente.contextMenu) {
				new Robot().mouseMove((cursor.x - 250), cursor.y);// Mover el raton a una posicion
			} else {
				if (editarHijo)
					new Robot().mouseMove((cursor.x - 250), (cursor.y - 250));// Mover el raton a una posicion
				else
					new Robot().mouseMove((cursor.x - 250), (cursor.y + 250));// Mover el raton a una posicion
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}

//		Meter las opciones de las tallas en el ComboBox
		cbTallas.setValue("Tallas");
		cbTallas.setItems(tallas);

		rellenarTallasPies();// Coger las opciones de cbPies

//		Meter las opciones de los pies en el ComboBox
		cbPies.setValue("Pies");
		cbPies.setItems(pies);

//		Agregar al Label el nombre del padre
		lblNombrePadre.setText("Nombre del Padre: " + cogerNombrePadre());

//		Comprobar si se ha presionado el boton Editar o Agregar
		if (editarHijo) {
			btnAgregar.setText("Guardar");// Se cambia el texto del Boton Agregar a Guardar

			hijo = buscarHijo(editarHijoConNombre);// Metodo para sacar la info del hijo del ArrayList

//			Agregar los parametros del Hijo a los componentes
			tfNombre.setText(hijo.getNombre());
			tfApellidos.setText(hijo.getApellidos());
			fechaNacimiento.setValue(hijo.getFecha_nacimiento());
			if (hijo.getSexo() == 'H') {
				btnSexoH.setSelected(true);
			}
			cbTallas.setValue(hijo.getTalla());
			cbPies.setValue(hijo.getPies());
		}

	}

	/*************************** METODOS FXML **************************/

//	Metodo para saber cuando se cierra la ventana
	@FXML
	private void windowsListener() {
//		Listener
		Main.frameFormularioHijos.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				FormularioCliente.habilitarComponentes();// Habiliar los componentes
			}
		});
	}

//	Metodo para saber si le doy al boton quitar
	@FXML
	private void quitarVentana() {
		FormularioCliente.habilitarComponentes();// Habilitar los componentes
		Main.frameFormularioHijos.close();// Cerrar ventana
	}

//	Metodo para hacer invisible un label
	@FXML
	private void errorPresionado() {
		lblErrorComboBox.setVisible(false);
	}

//	Metodo para agregar un hijo
	@FXML
	private void agregarHijo() {
		if (validacionDatosCliente()) {
			if (!editarHijo) {
//				Detectar sexo del hijo
				char sexo = '#';
				if (btnSexoH.isSelected())
					sexo = 'H';
				else
					sexo = 'M';

//				Objeto Hijo con los parametros introducidos
				Hijo hijo = new Hijo(tfNombre.getText(), tfApellidos.getText(), fechaNacimiento.getValue(), sexo,
						cbTallas.getValue(), cbPies.getValue());

				Hijo.guardarHijoTemp.add(hijo);// Hijo agregado al ArrayList

				fCliente.agregarHijoListView(hijo.getNombre());// Pasar el nombre del hijo y agregarlo al ListView
				FormularioCliente.habilitarComponentes();// Habilitar componentes
				Main.frameFormularioHijos.close();// Cerrar ventana
			} else {
//				Alert para avisar de que se han cambiado los datos
				Alerts.cambiosGuardados(hijo, fCliente, tfNombre.getText(), tfApellidos.getText(), fechaNacimiento.getValue(), btnSexoH.isSelected(), cbTallas.getValue(), cbPies.getValue());

			}

		}
	}

//	Metodo para detectar los TextField y el DatePicker
	@FXML
	private void camposPresionados() {
		if (tfNombre.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfNombre);
			errorEnElContenido[0] = false;
		} else {
			if (errorEnElContenido[0])
				EstilosCSS.fondoRojoConBordesRojos(tfNombre);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfNombre);
		}

		if (tfApellidos.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfApellidos);
			errorEnElContenido[1] = false;
		} else {
			if (errorEnElContenido[1])
				EstilosCSS.fondoRojoConBordesRojos(tfApellidos);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfApellidos);
		}

		if (fechaNacimiento.isFocused())
			EstilosCSS.fondoBlancoDatePicker(fechaNacimiento);

	}

	/***************************** METODOS *****************************/

//	Metodo para coger el nombre del padre
	private String cogerNombrePadre() {
		return FormularioCliente.nombrePadre;
	}

//	Metodo para buscar el hijo en el ArrayList
	private Hijo buscarHijo(String nombreHijo) {
		for (int i = 0; i < Hijo.guardarHijoTemp.size(); i++) {
			if (Hijo.guardarHijoTemp.get(i).getNombre().equals(nombreHijo)) {
				return Hijo.guardarHijoTemp.get(i);
			}
		}
		return null;
	}

//	Metodo para rellenar las opciones del ComboBox pies
	private void rellenarTallasPies() {
		for (int i = 18; i < 34; i++) {
			pies.add(i + "-" + (i + 1));
		}
	}

//	Metodo para validar datos
	private boolean validacionDatosCliente() {
		boolean todoCorrecto = true;
		boolean comboBoxCorrecto = true;
		String textoErrorComboBox = "";

		if (tfNombre.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfNombre);
			todoCorrecto = false;
			errorEnElContenido[0] = true;
		}
		if (tfApellidos.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfApellidos);
			todoCorrecto = false;
			errorEnElContenido[1] = true;
		}
		if (fechaNacimiento.getValue() == null) {
			EstilosCSS.fondoRojoDatePicker(fechaNacimiento);
			todoCorrecto = false;
		}
		if (cbTallas.getValue().equals("Tallas")) {
			textoErrorComboBox += "Selecciona el ComboBox Talla. ";
			todoCorrecto = false;
			comboBoxCorrecto = false;
		}
		if (cbPies.getValue().equals("Pies")) {
			textoErrorComboBox += "Selecciona el ComboBox Pies.";
			todoCorrecto = false;
			comboBoxCorrecto = false;
		}

		if (!comboBoxCorrecto) {
			lblErrorComboBox.setText(textoErrorComboBox);
			lblErrorComboBox.setVisible(true);// Hacer visible el label
		}

		return todoCorrecto;
	}

}
