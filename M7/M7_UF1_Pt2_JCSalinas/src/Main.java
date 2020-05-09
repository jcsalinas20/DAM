import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	DefaultListModel<String> noMatriculados = new DefaultListModel<String>();// Declaracion del DefaultListModel para
																				// los no matriculados
	DefaultListModel<String> matriculados = new DefaultListModel<String>();// Declaracion del DefaultListModel para los
																			// matriculados
	private JTextField nombreAlumno;// TextField para poner los nombres de los alumnos

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
		setBounds(100, 100, 600, 425);
		getContentPane().setLayout(null);

//		Alumnos no matriculado por defecto
		noMatriculados.addElement("Carlos");
		noMatriculados.addElement("Marc");
		noMatriculados.addElement("Oriol");

//		Creacion de JList para los no matriculados
		JList<String> listaNoMatriculados = new JList<String>();
		listaNoMatriculados.setBounds(30, 31, 165, 200);
		listaNoMatriculados.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		listaNoMatriculados.setModel(noMatriculados);// Agregar DefaultListModel a JList
		getContentPane().add(listaNoMatriculados);

//		Creacion de JList para los no matriculados
		JList<String> listaMatriculados = new JList<String>();
		listaMatriculados.setBounds(385, 31, 165, 200);
		listaMatriculados.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		listaMatriculados.setModel(matriculados);// Agregar DefaultListModel a JList
		getContentPane().add(listaMatriculados);

//		Boton para matricular alumnos
		JButton btnMatricular = new JButton("Matricular");
		btnMatricular.setBounds(229, 90, 132, 23);
		getContentPane().add(btnMatricular);
		btnMatricular.addActionListener(new ActionListener() {// Listener del boton Matricular
			public void actionPerformed(ActionEvent e) {
				int posicionesSeleccionadas[] = listaNoMatriculados.getSelectedIndices();// Guardar la posicion
				@SuppressWarnings("deprecation")
				Object[] nombreAlumnos = listaNoMatriculados.getSelectedValues();// Guardar los nombres seleccionados
				for (int i = posicionesSeleccionadas.length - 1; i >= 0; i--) {
					for (int j = 0; j < noMatriculados.size(); j++) {
						if (posicionesSeleccionadas[i] == j) {
							noMatriculados.remove(posicionesSeleccionadas[i]);// Borrar alumno
						}
					}
				}
				for (int i = 0; i < nombreAlumnos.length; i++) {
					matriculados.addElement((String) nombreAlumnos[i]);// Agregar alumno 
					listaMatriculados.setModel(matriculados);
				}
			}
		});

//		Boton para desmatricular alumnos
		JButton btnDesmatricular = new JButton("Desmatricular");
		btnDesmatricular.setBounds(229, 153, 132, 23);
		getContentPane().add(btnDesmatricular);
		btnDesmatricular.addActionListener(new ActionListener() {// Listener del boton Desmatricular
			public void actionPerformed(ActionEvent e) {
				int posicionesSeleccionadas[] = listaMatriculados.getSelectedIndices();// Guardar la posicion
				@SuppressWarnings("deprecation")
				Object[] nombreAlumnos = listaMatriculados.getSelectedValues();// Guardar los nombres seleccionados
				for (int i = posicionesSeleccionadas.length - 1; i >= 0; i--) {
					for (int j = 0; j < matriculados.size(); j++) {
						if (posicionesSeleccionadas[i] == j) {
							matriculados.remove(posicionesSeleccionadas[i]);// Borrar alumno
						}
					}
				}
				for (int i = 0; i < nombreAlumnos.length; i++) {
					noMatriculados.addElement((String) nombreAlumnos[i]);// Agregar alumno 
					listaNoMatriculados.setModel(noMatriculados);
				}
			}
		});

//		Boton para inscribir alumnos
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.setBounds(187, 271, 89, 23);
		getContentPane().add(btnInscribir);
		btnInscribir.addActionListener(new ActionListener() {// Listener del boton Inscribir
			public void actionPerformed(ActionEvent e) {
				if (!nombreAlumno.getText().isEmpty()) {// Comprobacion para que no este vacio
					noMatriculados.addElement(nombreAlumno.getText());// Agregar alumno 
					listaNoMatriculados.setModel(noMatriculados);
					nombreAlumno.setText("");// Borrar el texto
				}
			}
		});

//		TextField para introducir el nombre del alumno
		nombreAlumno = new JTextField();
		nombreAlumno.setBounds(65, 300, 210, 20);
		getContentPane().add(nombreAlumno);
		nombreAlumno.setColumns(10);

		JLabel lblNombreAlumno = new JLabel("Nombre alumno:");
		lblNombreAlumno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreAlumno.setBounds(66, 268, 99, 28);
		getContentPane().add(lblNombreAlumno);

//		Boton para quitar alumnos
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(65, 325, 210, 21);
		getContentPane().add(btnQuitar);
		btnQuitar.addActionListener(new ActionListener() {// Listener del boton Quitar
			public void actionPerformed(ActionEvent e) {
				int posicionesSeleccionadas[] = listaNoMatriculados.getSelectedIndices();// Guardar la posicion
				for (int i = posicionesSeleccionadas.length - 1; i >= 0; i--) {
					for (int j = 0; j < noMatriculados.size(); j++) {
						if (posicionesSeleccionadas[i] == j) {
							noMatriculados.remove(posicionesSeleccionadas[i]);//Borrar alumno
						}
					}
				}
			}
		});

		JLabel lblNoMatriculados = new JLabel("No Matriculados");
		lblNoMatriculados.setFont(new Font("Arial", Font.BOLD, 16));
		lblNoMatriculados.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoMatriculados.setBounds(30, 2, 165, 28);
		getContentPane().add(lblNoMatriculados);

		JLabel lblMatriculados = new JLabel("Matriculados");
		lblMatriculados.setFont(new Font("Arial", Font.BOLD, 16));
		lblMatriculados.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculados.setBounds(385, 2, 165, 28);
		getContentPane().add(lblMatriculados);

	}
}
