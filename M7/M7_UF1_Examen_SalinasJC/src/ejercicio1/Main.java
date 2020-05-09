package ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Scrollbar;

public class Main extends JFrame implements ActionListener {

	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<JButton> cursos = new ArrayList<JButton>();
	DefaultListModel<String> nuevosAlumnos = new DefaultListModel<String>();
	JList list;
	JTextField tfNom, tfApellido1, tfApellido2, tfTel;
	private JPanel contentPane;

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
		setBounds(100, 100, 993, 755);
		setResizable(false);
		setTitle("Examen SWING");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(12, 13, 265, 682);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(24, 13, 218, 357);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 20));

		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(24, 383, 218, 200);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
//				if (e.getSource() == list) {
//					for (int i = 0; i < alumnos.size(); i++) {
//						if (nuevosAlumnos.get(list.getSelectedIndex()).equals(alumnos.get(i).getNombre())) {
//							tfNom.setText(alumnos.get(i).getNombre());
//							tfApellido1.setText(alumnos.get(i).getApellido1());
//							tfApellido2.setText(alumnos.get(i).getApellido2());
//							tfTel.setText(alumnos.get(i).getTelefono());
//						}
//					}
//				}
			}

		});
//		JScrollPane jsp = new JScrollPane(list);
		panel.add(list);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(400, 100, 200, 40);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblNombre);
		JLabel lblApellido1 = new JLabel("Primer apellido: ");
		lblApellido1.setBounds(400, 200, 200, 40);
		lblApellido1.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblApellido1);
		JLabel lblApellido2 = new JLabel("Segundo apellido: ");
		lblApellido2.setBounds(400, 300, 200, 40);
		lblApellido2.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblApellido2);
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(400, 400, 200, 40);
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblTelefono);

		tfNom = new JTextField();
		tfNom.setBounds(599, 110, 116, 22);
		tfNom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(tfNom);
		tfNom.setColumns(10);

		tfApellido1 = new JTextField();
		tfApellido1.setBounds(599, 210, 116, 22);
		tfApellido1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(tfApellido1);
		tfApellido1.setColumns(10);

		tfApellido2 = new JTextField();
		tfApellido2.setBounds(599, 310, 116, 22);
		tfApellido2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(tfApellido2);
		tfApellido2.setColumns(10);

		tfTel = new JTextField();
		tfTel.setBounds(599, 410, 116, 22);
		tfTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(tfTel);
		tfTel.setColumns(10);

		cargarAlumnos();
		sacarCursos();

		for (int i = 0; i < cursos.size(); i++) {
			panel_1.add(cursos.get(i));
			cursos.get(i).addActionListener(this);
		}

	}

	private void sacarCursos() {
		String curso = alumnos.get(0).getCurso();
		JButton nombreCurso = new JButton(alumnos.get(0).getCurso());
		nombreCurso.setName(alumnos.get(0).getCurso());
		cursos.add(nombreCurso);
		for (int i = 0; i < alumnos.size(); i++) {
			if (!curso.equalsIgnoreCase(alumnos.get(i).getCurso())) {
				curso = alumnos.get(i).getCurso();
				nombreCurso = new JButton(alumnos.get(i).getCurso());
				nombreCurso.setName(alumnos.get(i).getCurso());
				cursos.add(nombreCurso);
			}
		}
	}

	private void cargarAlumnos() {
		Alumno alu3 = new Alumno("ap1_1", "ap2_1", "Nombre1", "456325234", "ASIX");
		alumnos.add(alu3);
		Alumno alu4 = new Alumno("ap1_2", "ap2_2", "Nombre2", "356746534", "ASIX");
		alumnos.add(alu4);
		Alumno alu1 = new Alumno("ap1_3", "ap2_3", "Nombre3", "789653342", "ASIX");
		alumnos.add(alu1);
		Alumno alu2 = new Alumno("ap1_4", "ap2_4", "Nombre4", "337638377", "ASIX");
		alumnos.add(alu2);
		Alumno alu2a = new Alumno("ap1_4a", "ap2_4a", "Nombre4a", "337638377a", "ASIX");
		alumnos.add(alu2a);
		Alumno alu2b = new Alumno("ap1_4b", "ap2_4b", "Nombre4b", "337638377b", "ASIX");
		alumnos.add(alu2b);
		Alumno alu2c = new Alumno("ap1_4c", "ap2_4c", "Nombre4c", "337638377c", "ASIX");
		alumnos.add(alu2c);
		Alumno alu2d = new Alumno("ap1_4d", "ap2_4d", "Nombre4d", "337638377d", "ASIX");
		alumnos.add(alu2d);
		Alumno alu5 = new Alumno("ap1_5", "ap2_5", "Nombre5", "345627277", "DAM");
		alumnos.add(alu5);
		Alumno alu6 = new Alumno("ap1_6", "ap2_6", "Nombre6", "245723672", "DAM");
		alumnos.add(alu6);
		Alumno alu7 = new Alumno("ap1_7", "ap2_7", "Nombre7", "845632235", "DAM");
		alumnos.add(alu7);
		Alumno alu8 = new Alumno("ap1_8", "ap2_8", "Nombre8", "345648335", "DAM");
		alumnos.add(alu8);
		Alumno alu9 = new Alumno("ap1_9", "ap2_9", "Nombre9", "345277376", "DAW");
		alumnos.add(alu9);
		Alumno alu10 = new Alumno("ap1_10", "ap2_10", "Nombre10", "2452626226", "DAW");
		alumnos.add(alu10);
		Alumno alu11 = new Alumno("ap1_11", "ap2_11", "Nombre11", "262623446", "DAW");
		alumnos.add(alu11);
		Alumno alu12 = new Alumno("ap1_12", "ap2_12", "Nombre12", "456346346", "DAW");
		alumnos.add(alu12);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		nuevosAlumnos.removeAllElements();
		for (int i = 0; i < alumnos.size(); i++) {
			if (e.getActionCommand().equalsIgnoreCase(alumnos.get(i).getCurso())) {
				nuevosAlumnos.addElement(alumnos.get(i).getNombre());
			}
		}
		list.setModel(nuevosAlumnos);
	}
}

class Alumno {
	// Atributos
	private String Apellido1;
	private String Apellido2;
	private String Nombre;
	private String telefono;
	private String curso;

	// Constructor
	public Alumno(String apellido1, String apellido2, String nombre, String telefono, String curso) {
		super();
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		Nombre = nombre;
		this.telefono = telefono;
		this.curso = curso;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
