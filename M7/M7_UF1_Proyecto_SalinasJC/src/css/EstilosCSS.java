package css;

import java.time.LocalDate;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import objetos.Cliente;
import objetos.Hijo;

public class EstilosCSS {

	public static void aumentarLetra(ListView<String> listaHijos) {
		listaHijos.setStyle("-fx-font-size:15.0;");
	}

	public static void fondoBlancoConBordesAzules(TextField textField) {
		textField.setStyle("-fx-background-color: #039ed3, #FFF;");
	}

	public static void fondoRojoConBordesRojos(TextField textField) {
		textField.setStyle("-fx-background-color: #DBB1B1, #FFF0F0;");
	}

	public static void fondoBlancoConBordesGrises(TextField textField) {
		textField.setStyle("-fx-background-color: #CBCBCB, #FFF;");
	}

	public static void fondoBlancoDatePicker(DatePicker fechaNacimiento) {
		fechaNacimiento.setStyle("-fx-control-inner-background: #FFF;");
	}

	public static void fondoRojoDatePicker(DatePicker fechaNacimiento) {
		fechaNacimiento.setStyle("-fx-control-inner-background: #DBB1B1, #FFF0F0;");
	}

	public static void centrarTextoTableSubscripcionesInteger(TableColumn<Cliente, Integer> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

	public static void centrarTextoTableSubscripcionesString(TableColumn<Cliente, String> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

	public static void centrarTextoTableSubscripcionesCharacter(TableColumn<Cliente, Character> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

	public static void centrarTextoTableSubscripcionesCheckBox(TableColumn<Cliente, CheckBox> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

	public static void centrarTextoTableHijosString(TableColumn<Hijo, String> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

	public static void centrarTextoTableHijosChararcter(TableColumn<Hijo, Character> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

	public static void centrarTextoTableHijosLocalDate(TableColumn<Hijo, LocalDate> column) {
		column.setStyle("-fx-alignment: CENTER;");
	}

}
