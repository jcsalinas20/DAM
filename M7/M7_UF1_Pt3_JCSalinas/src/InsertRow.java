import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertRow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCurso;
	private JLabel error;

	public InsertRow() {
		setTitle("Insertar Fila");
		setBounds(100, 100, 331, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(33, 49, 90, 22);
		contentPane.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(33, 107, 90, 22);
		contentPane.add(lblApellidos);

		JLabel lblCurso = new JLabel("Curso: ");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setBounds(33, 166, 90, 22);
		contentPane.add(lblCurso);

		textNombre = new JTextField();// Campo para insertar el nombre
		textNombre.setBounds(135, 51, 150, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textApellidos = new JTextField();// Campo para insertar el apellido
		textApellidos.setBounds(135, 109, 150, 22);
		contentPane.add(textApellidos);
		textApellidos.setColumns(10);

		textCurso = new JTextField();// Campo para insertar el curso
		textCurso.setBounds(135, 168, 50, 22);
		contentPane.add(textCurso);
		textCurso.setColumns(10);

		JButton btnInsertar = new JButton("Insertar");// Boton para insertar en el model la fila
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] row = new String[3];
				if (!textNombre.getText().isEmpty() && !textApellidos.getText().isEmpty()
						&& !textCurso.getText().isEmpty()) {// Comprobar que ningun campo este vacio
					row[0] = textNombre.getText();
					row[1] = textApellidos.getText();
					row[2] = textCurso.getText();
					Tablas.model.addRow(row);// Insertar fila en model
					dispose();
				} else {
					error.setText("Faltan campos por rellenar.");// Mostrar el error en el label
					error.setForeground(Color.red);
				}
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsertar.setBounds(87, 217, 126, 25);
		contentPane.add(btnInsertar);

		error = new JLabel("", JLabel.CENTER);// Label para mostrar un erro
		error.setFont(new Font("Tahoma", Font.ITALIC, 15));
		error.setBounds(33, 13, 252, 23);
		contentPane.add(error);
		setVisible(true);
	}
}
