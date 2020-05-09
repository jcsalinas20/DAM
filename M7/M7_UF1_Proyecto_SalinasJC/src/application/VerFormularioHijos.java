package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.ResourceBundle;

import css.EstilosCSS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.WindowEvent;
import objetos.Hijo;

public class VerFormularioHijos implements Initializable {

	/************************* VARIABLES FXML **************************/

	@FXML
	TableView<Hijo> tablaHijos;

	@FXML
	TableColumn<Hijo, String> nombre = new TableColumn<>();

	@FXML
	TableColumn<Hijo, String> apellidos = new TableColumn<>();

	@FXML
	TableColumn<Hijo, LocalDate> fecha = new TableColumn<>();

	@FXML
	TableColumn<Hijo, Character> sexo = new TableColumn<>();

	@FXML
	TableColumn<Hijo, String> talla = new TableColumn<>();

	@FXML
	TableColumn<Hijo, String> pies = new TableColumn<>();

	/**************************** VARIABLES ****************************/

	public static boolean verSubscripciones = false;// Boleano para saber si bien de AgregarCliente o Subscripciones
	public static int idCliente = 0;// Id del cliente seleccionado de la ventana Subscripciones

	/************************ METODO INITIALIZE ************************/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		CellValueFactory
		nombre.setCellValueFactory(new PropertyValueFactory<Hijo, String>("nombre"));
		apellidos.setCellValueFactory(new PropertyValueFactory<Hijo, String>("apellidos"));
		fecha.setCellValueFactory(new PropertyValueFactory<Hijo, LocalDate>("fecha_nacimiento"));
		sexo.setCellValueFactory(new PropertyValueFactory<Hijo, Character>("sexo"));
		talla.setCellValueFactory(new PropertyValueFactory<Hijo, String>("talla"));
		pies.setCellValueFactory(new PropertyValueFactory<Hijo, String>("pies"));

//		Estilos CSS
		EstilosCSS.centrarTextoTableHijosString(nombre);
		EstilosCSS.centrarTextoTableHijosString(apellidos);
		EstilosCSS.centrarTextoTableHijosLocalDate(fecha);
		EstilosCSS.centrarTextoTableHijosChararcter(sexo);
		EstilosCSS.centrarTextoTableHijosString(talla);
		EstilosCSS.centrarTextoTableHijosString(pies);

//		Comprobar de donde vengo
		if (verSubscripciones) {
			tablaHijos.setItems(mostrarHijosDesdeVerSubscripciones());
		} else {
			tablaHijos.setItems(mostrarHijosDesdeAgregarCliente());
		}
	}

	/*************************** METODOS FXML **************************/

//	Metodo para saber cuando se cierra la ventana
	@FXML
	private void windowsListener() {
		Main.frameVerFormularioHijos.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				FormularioCliente.habilitarComponentes();// Habilitar componentes
			}
		});
	}

	/***************************** METODOS *****************************/

//	Metodo para mostrar los hijo desde el HashMap
	private ObservableList<Hijo> mostrarHijosDesdeVerSubscripciones() {
		ObservableList<Hijo> hijos = FXCollections.observableArrayList();

		Iterator<Integer> iterator = Main.clientes.keySet().iterator();
		while (iterator.hasNext()) {
			Integer keyCliente = iterator.next();
			if (keyCliente == idCliente) {
				Iterator<String> iterator2 = Main.clientes.get(keyCliente).hijo.keySet().iterator();
				while (iterator2.hasNext()) {
					String keyHijo = iterator2.next();
					hijos.add(new Hijo(Main.clientes.get(keyCliente).hijo.get(keyHijo).getNombre(),
							Main.clientes.get(keyCliente).hijo.get(keyHijo).getApellidos(),
							Main.clientes.get(keyCliente).hijo.get(keyHijo).getFecha_nacimiento(),
							Main.clientes.get(keyCliente).hijo.get(keyHijo).getSexo(),
							Main.clientes.get(keyCliente).hijo.get(keyHijo).getTalla(),
							Main.clientes.get(keyCliente).hijo.get(keyHijo).getPies()));
				}
			}
		}

		return hijos;
	}

//	Metodo para mostrar los hijos desde el ArrayList
	private ObservableList<Hijo> mostrarHijosDesdeAgregarCliente() {
		ObservableList<Hijo> hijos = FXCollections.observableArrayList();
		for (int i = 0; i < Hijo.guardarHijoTemp.size(); i++) {
			hijos.add(Hijo.guardarHijoTemp.get(i));
		}
		return hijos;
	}

}
