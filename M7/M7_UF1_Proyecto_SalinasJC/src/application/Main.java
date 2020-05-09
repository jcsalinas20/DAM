package application;

import java.time.LocalDate;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import objetos.Cliente;
import objetos.Hijo;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;

public class Main extends Application {

	private static Stage frameFormularioClientes;
	public static Stage frameFormularioHijos;
	public static Stage frameVerFormularioHijos;
	private static Stage frameSubscripciones;

//	HashMap para guardar clientes
	public static HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

//	Main Windows
	@Override
	public void start(Stage primaryStage) {
		introduccionDeDatosEnElHashMap();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/FormularioClient.fxml"));
			Scene scene = new Scene(root, 870, 600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Añadir Clientes");
			primaryStage.setResizable(false);
			frameFormularioClientes = primaryStage;
			frameFormularioClientes.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Windows Formulario Cliente
	public void frameAgregarCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/FormularioClient.fxml"));
			Parent root = (Parent) loader.load();
			frameFormularioClientes = new Stage();
			frameFormularioClientes.setTitle("Formulario Cliente");
			frameFormularioClientes.setScene(new Scene(root));
			frameFormularioClientes.setResizable(false);
			frameSubscripciones.close();
			frameFormularioClientes.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Windows Formulario Hijo
	public void frameAgregarHijo() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/FormularioHijos.fxml"));
			Parent root = (Parent) loader.load();
			frameFormularioHijos = new Stage();
			frameFormularioHijos.setTitle("Formulario Hijos");
			frameFormularioHijos.setScene(new Scene(root));
			frameFormularioHijos.setResizable(false);
			frameFormularioHijos.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Windows Subscripciones
	public void frameSubscripciones() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Subscripciones.fxml"));
			Parent root = (Parent) loader.load();
			frameSubscripciones = new Stage();
			frameSubscripciones.setTitle("Subscripciones");
			frameSubscripciones.setScene(new Scene(root));
			frameSubscripciones.setResizable(false);
			frameFormularioClientes.close();
			frameSubscripciones.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Windows Ver Hijos
	public void frameVerHijos() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/VerFormularioHijos.fxml"));
			Parent root = (Parent) loader.load();
			frameVerFormularioHijos = new Stage();
			frameVerFormularioHijos.setTitle("Hijos");
			frameVerFormularioHijos.setScene(new Scene(root));
			frameVerFormularioHijos.setResizable(false);
			frameVerFormularioHijos.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Metodo para meter datos por defecto
	private void introduccionDeDatosEnElHashMap() {
		clientes.put(1, new Cliente(1, "Carlos", "Salinas Navarrete", "carlos20@gmail.com", 665436598, 'H', "c/ Carrer del Comte d'Urgell 11 2º B", "06520", "Catalu\u00f1a", "Barcelona", new CheckBox()));
		clientes.put(2, new Cliente(2, "Andrea", "Lopez Garcia", "andrea20@gmail.com", 645145254, 'M', "av/ Granada 6A 1º 1ª", "01540", "Madrid", "Madrid", new CheckBox()));
		clientes.put(3, new Cliente(3, "Eric", "Sanz Moreno", "eric20@gmail.com", 658324956, 'H', "c/ Aceuchal 4º 6C", "09870", "Jaen", "Huelma", new CheckBox()));
		clientes.put(4, new Cliente(4, "Marc", "Gutierrez Zamora", "marc20@gmail.com", 753689541, 'H', "c/ Arcos 96", "02140", "Catalu\u00f1a", "Martorell", new CheckBox()));
		clientes.put(5, new Cliente(5, "Elsa", "Puello Suarez", "elsa20@gmail.com", 745362125, 'M', "c/ Galicia 45 7A", "08760", "Catalu\u00f1a", "Abrera", new CheckBox()));

		clientes.get(1).hijo.put("1-1", new Hijo("1-1", "Maria", "Salinas Navarrete", LocalDate.now(), 'M', "2-3 a\u00f1os", "23-24"));
		clientes.get(1).hijo.put("1-2", new Hijo("1-2", "Julia", "Salinas Navarrete", LocalDate.now(), 'M', "6-7 a\u00f1os", "25-26"));
		clientes.get(2).hijo.put("2-1", new Hijo("2-1", "Dana", "Lopez Garcia", LocalDate.now(), 'M', "9-10 a\u00f1os", "27-28"));
		clientes.get(2).hijo.put("2-2", new Hijo("2-2", "Adrian", "Lopez Garcia", LocalDate.now(), 'H', "3-4 a\u00f1os", "23-24"));
		clientes.get(3).hijo.put("3-1", new Hijo("3-1", "Fernanda", "Sanz Moreno", LocalDate.now(), 'M', "1-2 a\u00f1os", "21-22"));
		clientes.get(4).hijo.put("4-1", new Hijo("4-1", "Oscar", "Gutierrez Zamora", LocalDate.now(), 'H', "2-3 a\u00f1os", "22-23"));
		clientes.get(5).hijo.put("5-1", new Hijo("5-1", "Ariana", "Puello Suarez", LocalDate.now(), 'M', "1-2 a\u00f1os", "20-21"));
		clientes.get(5).hijo.put("5-2", new Hijo("5-2", "Oriol", "Puello Suarez", LocalDate.now(), 'H', "4-5 a\u00f1os", "23-24"));
	}

	public static void main(String[] args) {
		launch(args);
	}

}
