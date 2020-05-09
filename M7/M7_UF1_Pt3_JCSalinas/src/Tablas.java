import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tablas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static DefaultTableModel model = new DefaultTableModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablas frame = new Tablas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tablas() {
		setTitle("Tabla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 403);
		contentPane = new JPanel();

		final String[] nomCol = { "Nombre", "Apellidos", "Curso" };// Columnas de la tabla
		model.setColumnIdentifiers(nomCol);

		String[][] datos = { { "Carlos", "Salinas", "AMS" }, { "Oscar", "Alonso", "AWS" },
				{ "Victor", "Gracia", "SMX" } };// Filas de la tabla por defecto
		for (int i = 0; i < datos.length; i++) {
			model.insertRow(i, datos[i]);
		}
		contentPane.setLayout(null);

		JTable tabla = new JTable(model);// Creacion de la tabla
		tabla.setFont(new Font("Arail", Font.PLAIN, 16));
		tabla.setRowHeight(27);

		JScrollPane jsp = new JScrollPane(tabla);
		jsp.setBounds(30, 0, 484, 287);

		contentPane.add(jsp);

		setContentPane(contentPane);

		JButton btnInsertar = new JButton("Insertar");// Boton para insertar
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsertar.setBounds(60, 310, 128, 25);
		contentPane.add(btnInsertar);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertRow();// Abrir nueva ventana para insertar fila
			}
		});

		JButton btnEliminar = new JButton("Eliminar");// Boton para eliminar
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setBounds(343, 312, 128, 25);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rowsSeleccionadas = tabla.getSelectedRows();
				for (int i = rowsSeleccionadas.length - 1; i >= 0; i--) {
					for (int j = 0; j < model.getRowCount(); j++) {
						if (j == rowsSeleccionadas[i]) {
							model.removeRow(j);// Eliminar filas del model en orden ascndente
						}
					}
				}

			}
		});
	}
}
