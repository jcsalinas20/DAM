package application;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import css.EstilosCSS;
import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import objetos.Cliente;
import otros.Alerts;

public class Subscripciones extends Application implements Initializable {

	/************************* VARIABLES FXML **************************/

	@FXML
	TableView<Cliente> tabla;

	@FXML
	TableColumn<Cliente, Integer> id = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> nombre = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> apellidos = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> email = new TableColumn<>();

	@FXML
	TableColumn<Cliente, Integer> telefono = new TableColumn<>();

	@FXML
	TableColumn<Cliente, Character> sexo = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> direccion = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> cp = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> provincia = new TableColumn<>();

	@FXML
	TableColumn<Cliente, String> localidad = new TableColumn<>();

	@FXML
	TableColumn<Cliente, CheckBox> recibirCaja = new TableColumn<>();

	/**************************** VARIABLES ****************************/

	Main main = new Main();

	/************************ METODO INITIALIZE ************************/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		CellValueFactory
		id.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
		nombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
		apellidos.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellidos"));
		email.setCellValueFactory(new PropertyValueFactory<Cliente, String>("correo"));
		telefono.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("telefono"));
		sexo.setCellValueFactory(new PropertyValueFactory<Cliente, Character>("sexo"));
		direccion.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));
		cp.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cp"));
		provincia.setCellValueFactory(new PropertyValueFactory<Cliente, String>("provincia"));
		localidad.setCellValueFactory(new PropertyValueFactory<Cliente, String>("localidad"));
		recibirCaja.setCellValueFactory(new PropertyValueFactory<Cliente, CheckBox>("recibirCajaEsteMes"));

//		Estilos CSS
		EstilosCSS.centrarTextoTableSubscripcionesInteger(id);
		EstilosCSS.centrarTextoTableSubscripcionesString(nombre);
		EstilosCSS.centrarTextoTableSubscripcionesString(apellidos);
		EstilosCSS.centrarTextoTableSubscripcionesString(email);
		EstilosCSS.centrarTextoTableSubscripcionesInteger(telefono);
		EstilosCSS.centrarTextoTableSubscripcionesCharacter(sexo);
		EstilosCSS.centrarTextoTableSubscripcionesString(direccion);
		EstilosCSS.centrarTextoTableSubscripcionesString(cp);
		EstilosCSS.centrarTextoTableSubscripcionesString(provincia);
		EstilosCSS.centrarTextoTableSubscripcionesString(localidad);
		EstilosCSS.centrarTextoTableSubscripcionesCheckBox(recibirCaja);

//		Agregar clientes a la tabla
		agregarClientes();
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

//	Metodo para mostrar los hijos
	@FXML
	private void mostrarHijos() {
		if (tabla.getSelectionModel().getSelectedIndex() != -1) {
//			Sacar id del cliente seleccionado
			VerFormularioHijos.idCliente = (tabla.getSelectionModel().getSelectedIndex() + 1);// Sacar id del cliente
			VerFormularioHijos.verSubscripciones = true;// Boleano para saber que vengo de la ventana de subscripciones

			main.frameVerHijos();
		} else {
//			Alert hijo no seleccionado
			Alerts.noSeleccionado("Cliente no seleccionado", "Selecciona un Cliente para poder ver sus hijos.");
		}
	}

//	Metodo para eliminar cliente
	@FXML
	private void eliminarCliente() {
		if (tabla.getSelectionModel().getSelectedIndex() != -1) {

			Cliente cliente = (tabla.getSelectionModel().getSelectedItem());// Sacar el cliente

			Main.clientes.remove(cliente.getId());// Eliminar cliente

			tabla.getItems().clear();
			agregarClientes();// actualizar
		} else {
//			Alert hijo no seleccionado
			Alerts.noSeleccionado("Cliente no seleccionado", "Selecciona un Cliente para poder eliminarlo.");
		}
	}

//	Cambiar de ventana a Agregar Cliente
	@FXML
	private void menuOptionCliente() {
		main.frameAgregarCliente();
	}

	@FXML
	private void menuOptionExit() {
		Alerts.terminarPrograma();// Alert para terminar el programa
	}

	/***************************** METODOS *****************************/

//	Metodo para agregar clientes a la Tabla
	private void agregarClientes() {
		Iterator<Integer> iterator = Main.clientes.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			tabla.getItems()
					.add(new Cliente(Main.clientes.get(key).getId(), Main.clientes.get(key).getNombre(),
							Main.clientes.get(key).getApellidos(), Main.clientes.get(key).getCorreo(),
							Main.clientes.get(key).getTelefono(), Main.clientes.get(key).getSexo(),
							Main.clientes.get(key).getDireccion(), Main.clientes.get(key).getCp(),
							Main.clientes.get(key).getProvincia(), Main.clientes.get(key).getLocalidad(),
							Main.clientes.get(key).getRecibirCajaEsteMes()));
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
}
