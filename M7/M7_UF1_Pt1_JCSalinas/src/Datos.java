import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;

public class Datos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Datos() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		String nombre = "Nombre: " + Main.textField.getText();

		String ciudad = "Ciudad: " + comprobacionCiudad();

		String aficiones = "Aficiones: " + comprobacionAficiones();

		String generoSeleccionado = "Genero: " + comprobacionRadioButtons();

		TextArea tArea = new TextArea(nombre + "\n" + ciudad + "\n" + aficiones + "\n" + generoSeleccionado);
		contentPane.add(tArea, BorderLayout.CENTER);

		setVisible(true);
	}

	private String comprobacionAficiones() {
		String aficiones = "";
		if (Main.chckbxGolf.isSelected()) {
			aficiones += "Golf ";
		}
		if (Main.chckbxTenis.isSelected()) {
			aficiones += "Tenis ";
		}
		if (Main.chckbxPadel.isSelected()) {
			aficiones += "Padel ";
		}
		if (Main.chckbxPetanca.isSelected()) {
			aficiones += "Petanca ";
		}
		return aficiones;
	}

	private String comprobacionCiudad() {
		String ciudad = (String) Main.comboBox.getSelectedItem();
		return ciudad;
	}

	private String comprobacionRadioButtons() {
		String genero = "";
		if (Main.rdbtnHombre.isSelected()) {
			genero = "Hombre";
		} else {
			genero = "Mujer";
		}
		return genero;
	}

}
