package application;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import css.EstilosCSS;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import objetos.Cliente;
import objetos.Hijo;
import otros.Alerts;

public class FormularioCliente extends Application implements Initializable {

	/************************* VARIABLES FXML **************************/

	@FXML
	ListView<String> listaHijos = new ListView<String>();// Lista de los nombres de los hijos

	@FXML
	RadioButton btnSexoH;

	@FXML
	RadioButton btnSexoM;

	@FXML
	CheckBox cbRecibirCaja;

	@FXML
	TextField tfNombre;

	@FXML
	TextField tfApellidos;

	@FXML
	TextField tfCorreo;

	@FXML
	TextField tfTelefono;

	@FXML
	TextField tfDireccion;

	@FXML
	TextField tfCP;

	@FXML
	TextField tfProvincia;

	@FXML
	TextField tfLocalidad;

	@FXML
	Button btnTerminar;// Boton para agregar un cliente y sus hijos al HashMap

	@FXML
	Button btnAgregarHijo;// Boton para agregar un hijo al ListView

	@FXML
	Button btnEditarHijo;// Boton para editar un hijo ya existente

	@FXML
	MenuBar menuBar;

	/**************************** VARIABLES ****************************/

	Main main = new Main();

	static ObservableList<String> items = FXCollections.observableArrayList();// Guardar nombre de hijos
	public static String nombrePadre;// Nombre del padre

//	Array de booleans para saber si hay algun error al agregar el cliente al HashMap
	boolean[] errorEnElContenido = { false, false, false, false, false, false, false, false };

	ContextMenu cMenu = new ContextMenu();// ContextMenu del ListView
	MenuItem agregar, editar, ver, eliminar;// Opciones del ContextMenu

	static boolean primerHijo = true;// Detecta si es el primer hijo que se agrega
	public static boolean contextMenu = false;// Detecta si se accede des del ContextMenu
	public static boolean componentesHabilitados = true;// Para habilitar o deshabilitar componentes

	/************************ METODO INITIALIZE ************************/

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listaHijos.getItems().clear();// Limpiar ListView
		items.clear();// Limpiar el ObservableList
		primerHijo = true;// Que detecte el primer hijo
		Hijo.guardarHijoTemp.clear();// Limpiar el ArrayList de Hijos temporal

		items.add("");// Agregar elemento vacio al ObservableList
		listaHijos.setItems(items);// Agregar los elementos del Obsevable al ListView
		EstilosCSS.aumentarLetra(listaHijos);

//		Elementos del ContextMenu
		agregar = new MenuItem("Agregar");
		editar = new MenuItem("Editar");
		ver = new MenuItem("Ver");
		eliminar = new MenuItem("Eliminar");

//		Agregar elementos al ContextMenu
		cMenu.getItems().addAll(agregar, new SeparatorMenuItem(), editar, new SeparatorMenuItem(), ver,
				new SeparatorMenuItem(), eliminar);

//		Listener de Agregar el ContextMenu
		agregar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				agregarHijo();// llamada al metodo para agregar un hijo
			}
		});
//		Listener de Editar el ContextMenu
		editar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				editarHijo();// llamada al metodo para editar un hijo
			}
		});
//		Listener de Ver el ContextMenu
		ver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				booleano para saber si accedemos desde aqui o la ventana Subscripciones
				VerFormularioHijos.verSubscripciones = false;
				componentesHabilitados = false;// False para deshabilitar los componentes
				habilitarDeshabilitarComponentes();// Deshabilitamos los componentes

				main.frameVerHijos();// Cambiamos de ventana
			}
		});
//		Listener de Eliminar el ContextMenu
		eliminar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < items.size(); i++) {
//					Comprobamos el nombre del seleccionado en el ArrayList para saber su posicion
					if (listaHijos.getSelectionModel().getSelectedItem()
							.equals(Hijo.guardarHijoTemp.get(i).getNombre())) {
						Hijo.guardarHijoTemp.remove(i);// Eliminacion del hijo
					}
				}
				items.remove(listaHijos.getSelectionModel().getSelectedIndex());// Eliminacion del Observable
				listaHijos.setItems(items);// Agregamos los items otra vez
//				Si el size es de 0 agregamos un elemento vacio
				if (items.size() == 0) {
					items.add("");
					listaHijos.setItems(items);
				}
//				Lo ponemos en null para que no puedas editar el nombre del hijo anterior
				FormularioHijos.editarHijoConNombre = null;
			}
		});

		habilitarDeshabilitarComponentes();// Deshabilitamos o habilitamos los componentes
	}

	/*************************** METODOS FXML **************************/

	@FXML
	private void mostrarInformeCliente() {
		String dirTreball = System.getProperty("user.dir");
		File file = new File(dirTreball + File.separator + "ListaClientes.pdf");
		HostServices hostServices = getHostServices();
		hostServices.showDocument(file.getAbsolutePath());
	}

	@FXML
	private void mostrarInformeProductos() {
		String dirTreball = System.getProperty("user.dir");
		File file = new File(dirTreball + File.separator + "ListaProductos.pdf");
		HostServices hostServices = getHostServices();
		hostServices.showDocument(file.getAbsolutePath());
	}
	
//	Metodo para deshabilitar o habilitar los componentes
	@FXML
	public void habilitarDeshabilitarComponentes() {
		if (componentesHabilitados) {
			btnAgregarHijo.setDisable(false);// Button
			btnEditarHijo.setDisable(false);// Button
			btnTerminar.setDisable(false);// Button
			menuBar.setDisable(false);// Menu
			listaHijos.setDisable(false);// ListView
		} else {
			btnAgregarHijo.setDisable(true);// Button
			btnEditarHijo.setDisable(true);// Button
			btnTerminar.setDisable(true);// Button
			menuBar.setDisable(true);// Menu
			listaHijos.setDisable(true);// ListView
		}
	}

//	Metodo para cambiar de ventana con el Menu(Ver > Subscripciones) a Subscripciones
	@FXML
	private void menuOptionSubscripciones() {
		main.frameSubscripciones();
	}

//	Metodo para terminar el programa con una opcion del Menu(Opciones > Exit)
	@FXML
	private void menuOptionExit() {
		Alerts.terminarPrograma();// Llamada de un metodo para que aparezca un Alert
	}

//	Metodo para mostrar el ContextMenu del ListView
	@FXML
	private void contextMenuOptions() {
//		Listener de ListView
		listaHijos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent cursor) {
//				Si detecta el boton derecho del raton entra
				if (cursor.getButton().equals(MouseButton.SECONDARY)) {
					cMenu.show(listaHijos, cursor.getScreenX(), cursor.getScreenY());// Mostrar ContextMenu
//					Si detecta que el elemento es el vacio deahabilita las opciones menos la de Agregar
					if (listaHijos.getSelectionModel().getSelectedItem().equals("")) {
						editar.setDisable(true);
						ver.setDisable(true);
						eliminar.setDisable(true);
					} else {
						editar.setDisable(false);
						ver.setDisable(false);
						eliminar.setDisable(false);
					}
				} else {
//					Si no es el boton derecho lo oculta
					cMenu.hide();
				}
			}
		});
	}

//	Metodo para agregar un cliente al HashMap
	@FXML
	public void agregarCliente() {
		char sexo = '#';// Variable para almacenar el sexo
//		Validacion que sexo esta seleccionado
		if (btnSexoH.isSelected())
			sexo = 'H';
		else
			sexo = 'M';

//		IF validando todos los datos del cliente
		if (validacionDatosCliente()) {
			CheckBox caja = new CheckBox();// Declaracion de un CheckBox
			caja.setSelected(cbRecibirCaja.isSelected());// Pasar de un CheckBox a otro si esta seleccionado o no

//			Primero agregamos el cliente al HashMap
			if (Main.clientes.size() == 0) {
				Main.clientes.put(1,
						new Cliente(1, tfNombre.getText(), tfApellidos.getText(), tfCorreo.getText(),
								Integer.parseInt(tfTelefono.getText()), sexo, tfDireccion.getText(), tfCP.getText(),
								tfProvincia.getText(), tfLocalidad.getText(), caja));
			} else {
				int ultimoIdCliente = 0;
				Iterator<Integer> iterator = Main.clientes.keySet().iterator();
				while (iterator.hasNext()) {
					ultimoIdCliente = iterator.next();
				}
				Main.clientes.put(ultimoIdCliente + 1,
						new Cliente(ultimoIdCliente + 1, tfNombre.getText(), tfApellidos.getText(), tfCorreo.getText(),
								Integer.parseInt(tfTelefono.getText()), sexo, tfDireccion.getText(), tfCP.getText(),
								tfProvincia.getText(), tfLocalidad.getText(), caja));
			}

//			Despues agregamos los hijos al HashMap
			for (int i = 0; i < Hijo.guardarHijoTemp.size(); i++) {
				Main.clientes.get(Main.clientes.size()).hijo.put(Main.clientes.size() + "-" + (i + 1),
						new Hijo(Main.clientes.size() + "-" + (i + 1), Hijo.guardarHijoTemp.get(i).getNombre(),
								Hijo.guardarHijoTemp.get(i).getApellidos(),
								Hijo.guardarHijoTemp.get(i).getFecha_nacimiento(),
								Hijo.guardarHijoTemp.get(i).getSexo(), Hijo.guardarHijoTemp.get(i).getTalla(),
								Hijo.guardarHijoTemp.get(i).getPies()));
			}

			limpiarDatos();// Metodo para limpiar todos los campos del formulario incluido el ListView
		}
	}

//	Metodo para editar un hijo existente del ListView
	@FXML
	private void editarHijo() {
//		Comprobacion para saber si se ha seleccionado un elemento del ListView
		if (FormularioHijos.editarHijoConNombre != null) {
//			Comprobacion para saber que el hijo seleccionado no sea el elemento vacio
			if (!FormularioHijos.editarHijoConNombre.equals("")) {
				try {
//					Ver desde donde se entra, si desdel Button o el ContextMenu
					if (btnEditarHijo.isFocused()) {
						contextMenu = false;
					} else {
						contextMenu = true;
					}

//					Boleano para saber si se accede desde la opcion de Editar o Agregar
					FormularioHijos.editarHijo = true;
					nombrePadre = tfNombre.getText();// Coger el nombre del padre
					componentesHabilitados = false;// Boleano para deshabilitar los componentes

					habilitarDeshabilitarComponentes();// Deshabilitar los componentes

					main.frameAgregarHijo();// Mostrar la ventana del formulario del hijo
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
//				Metodo para mostrar un Alert de Error
				Alerts.noSeleccionado("Hijo no seleccionado", "No se ha seleccionado ningun hijo.");
			}
		} else {
//			Metodo para mostrar un Alert de Error
			Alerts.noSeleccionado("Hijo no seleccionado", "No se ha seleccionado ningun hijo.");
		}
	}

//	Metodo para saber el nombre del hijo seleccionado del ListView
	@FXML
	public void seleccionHijo() {
		FormularioHijos.editarHijoConNombre = listaHijos.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void agregarHijo() {
		try {
//			Ver desde donde se entra, si desdel Button o el ContextMenu
			if (btnAgregarHijo.isFocused()) {
				contextMenu = false;
			} else {
				contextMenu = true;
			}

//			Boleano para saber si se accede desde la opcion de Editar o Agregar
			FormularioHijos.editarHijo = false;
			nombrePadre = tfNombre.getText();// Coger el nombre del padre
			componentesHabilitados = false;// Boleano para deshabilitar los componentes

			habilitarDeshabilitarComponentes();// Deshabilitar los componentes

			main.frameAgregarHijo();// Mostrar la ventana del formulario del hijo
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Metodo para saber donde esta el Focus de los TextFields
	@FXML
	private void textFieldPress() {
//		TextField (nombre)
		if (tfNombre.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfNombre);
			errorEnElContenido[0] = false;// La posicion del Array se restaura a false al presionarlo
		} else {
			if (errorEnElContenido[0])
				EstilosCSS.fondoRojoConBordesRojos(tfNombre);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfNombre);
		}

//		TextField (apellidos)
		if (tfApellidos.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfApellidos);
			errorEnElContenido[1] = false;
		} else {
			if (errorEnElContenido[1])
				EstilosCSS.fondoRojoConBordesRojos(tfApellidos);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfApellidos);
		}

//		TextField (correo)
		if (tfCorreo.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfCorreo);
			errorEnElContenido[2] = false;
		} else {
			if (errorEnElContenido[2])
				EstilosCSS.fondoRojoConBordesRojos(tfCorreo);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfCorreo);
		}

//		TextField (telefono)
		if (tfTelefono.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfTelefono);
			errorEnElContenido[3] = false;
		} else {
			if (errorEnElContenido[3])
				EstilosCSS.fondoRojoConBordesRojos(tfTelefono);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfTelefono);
		}

//		TextField (direccion)
		if (tfDireccion.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfDireccion);
			errorEnElContenido[4] = false;
		} else {
			if (errorEnElContenido[4])
				EstilosCSS.fondoRojoConBordesRojos(tfDireccion);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfDireccion);
		}

//		TextField (codigo postal)
		if (tfCP.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfCP);
			errorEnElContenido[5] = false;
		} else {
			if (errorEnElContenido[5])
				EstilosCSS.fondoRojoConBordesRojos(tfCP);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfCP);
		}

//		TextField (provincia)
		if (tfProvincia.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfProvincia);
			errorEnElContenido[6] = false;
		} else {
			if (errorEnElContenido[6])
				EstilosCSS.fondoRojoConBordesRojos(tfProvincia);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfProvincia);
		}

//		TextField (localidad)
		if (tfLocalidad.isFocused()) {
			EstilosCSS.fondoBlancoConBordesAzules(tfLocalidad);
			errorEnElContenido[7] = false;
		} else {
			if (errorEnElContenido[7])
				EstilosCSS.fondoRojoConBordesRojos(tfLocalidad);
			else
				EstilosCSS.fondoBlancoConBordesGrises(tfLocalidad);
		}
	}

	/***************************** METODOS *****************************/

//	Metodo para agregar el hijo al ListView
	public void agregarHijoListView(String item) {
		items.add(item);// Agregar el nombre al Observable
		listaHijos.setItems(items);// Agregar Observable al ListView
//		Si es el primer hijo ...
		if (primerHijo) {
			primerHijo = false;// Pasar a false
			listaHijos.getItems().remove(0);// Eliminar el elemento vacio
		}
	}

//	Metodo para cambiar el nombre del hijo si es editado
	public void editarNombreHijo(String nombreNuevo, String nombreAntiguo) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(nombreAntiguo)) {// Comprobar nombre del Observable con el antiguo
				items.set(i, nombreNuevo);// Substituir el antiguo por el nuevo
			}
		}
	}

//	Metodo para limpiar los campos una vez agregado el cliente al HashMap
	private void limpiarDatos() {
		tfNombre.setText("");// TextField
		tfApellidos.setText("");// TextField
		tfCorreo.setText("");// TextField
		tfTelefono.setText("");// TextField
		tfDireccion.setText("");// TextField
		tfCP.setText("");// TextField
		tfProvincia.setText("");// TextField
		tfLocalidad.setText("");// TextField
		btnSexoM.setSelected(true);// RadioButton
		cbRecibirCaja.setSelected(true);// CheckBox
		listaHijos.getItems().clear();// Limpiar ListView
		items.clear();// Limpiar Observable
		items.add("");// Agregar elemento vacio al ListView
		primerHijo = true;// Primer hijo true
		listaHijos.setItems(items);// Agregar el Observable al ListView
		Hijo.guardarHijoTemp.clear();// Limpiar el ArrayList de Hijo
	}

//	Metodo para validar los datos del formulario del cliente
	private boolean validacionDatosCliente() {
		boolean todoCorrecto = true;// true: todos los datos estan correctos

//		Si la longitud del ArrayList es de 0 esta mal
		if (Hijo.guardarHijoTemp.size() == 0) {
//			Mostrar Alert de Error
			Alerts.noSeleccionado("Hijos no introducidos.", "Se necesita introducir al menos 1 hijo para continuar.");
			todoCorrecto = false;// No esta correcto
		}

//		Comprobar si el TextField esta vacio
		if (tfNombre.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfNombre);
			todoCorrecto = false;
			errorEnElContenido[0] = true;// Array para saber donde esta mal
		}
		if (tfApellidos.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfApellidos);
			todoCorrecto = false;
			errorEnElContenido[1] = true;
		}
		if (tfCorreo.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfCorreo);
			todoCorrecto = false;
			errorEnElContenido[2] = true;
		}
		if (tfTelefono.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfTelefono);
			todoCorrecto = false;
			errorEnElContenido[3] = true;
		}
		if (tfDireccion.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfDireccion);
			todoCorrecto = false;
			errorEnElContenido[4] = true;
		}
		if (tfCP.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfCP);
			todoCorrecto = false;
			errorEnElContenido[5] = true;
		}
		if (tfProvincia.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfProvincia);
			todoCorrecto = false;
			errorEnElContenido[6] = true;
		}
		if (tfLocalidad.getText().equals("")) {
			EstilosCSS.fondoRojoConBordesRojos(tfLocalidad);
			todoCorrecto = false;
			errorEnElContenido[7] = true;
		}

		return todoCorrecto;
	}

//	Metodo para habilitar el boolean de los componentes desde otra clase
	public static void habilitarComponentes() {
		componentesHabilitados = true;
	}

@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	
}

}
