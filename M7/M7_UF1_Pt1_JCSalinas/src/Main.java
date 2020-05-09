import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	private JLabel lblCiudad;
	static JRadioButton rdbtnHombre, rdbtnMujer;
	static JCheckBox chckbxTenis, chckbxPadel, chckbxGolf, chckbxPetanca;
	static JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(32, 40, 74, 14);
		contentPane.add(lblNombre);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(116, 40, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCiudad.setBounds(40, 89, 66, 14);
		contentPane.add(lblCiudad);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Elige una opcion", "Martorell", "Abrera", "Olesa de Montserrat" }));
		comboBox.setBounds(116, 89, 144, 20);
		contentPane.add(comboBox);

		JLabel lblAficiones = new JLabel("Aficiones");
		lblAficiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAficiones.setBounds(32, 138, 74, 14);
		contentPane.add(lblAficiones);

		chckbxTenis = new JCheckBox("Tenis");
		chckbxTenis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTenis.setBounds(32, 177, 66, 23);
		contentPane.add(chckbxTenis);

		chckbxPadel = new JCheckBox("Padel");
		chckbxPadel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPadel.setBounds(116, 177, 66, 23);
		contentPane.add(chckbxPadel);

		chckbxGolf = new JCheckBox("Golf");
		chckbxGolf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGolf.setBounds(32, 214, 66, 23);
		contentPane.add(chckbxGolf);

		chckbxPetanca = new JCheckBox("Petanca");
		chckbxPetanca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPetanca.setBounds(116, 214, 81, 23);
		contentPane.add(chckbxPetanca);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenero.setBounds(285, 141, 66, 14);
		contentPane.add(lblGenero);

		ButtonGroup grupo = new ButtonGroup();
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHombre.setBounds(285, 179, 74, 23);
		grupo.add(rdbtnHombre);
		contentPane.add(rdbtnHombre);

		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMujer.setBounds(285, 216, 66, 23);
		grupo.add(rdbtnMujer);
		contentPane.add(rdbtnMujer);

		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean comprobacionNombre = false, combrobacionCiudad = false;
				if (!textField.getText().equals("")) {
					comprobacionNombre = true;
				}
				if (comboBox.getSelectedIndex() != 0) {
					combrobacionCiudad = true;
				}
				if (combrobacionCiudad && comprobacionNombre) {
					new Datos();
				} else {
					JOptionPane.showMessageDialog(null, "Falan compronentes por rellenar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnviar.setBounds(10, 258, 414, 31);
		contentPane.add(btnEnviar);
	}
}
