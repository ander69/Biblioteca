package Biblioteca;


import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JBiblioteca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private Biblioteca biblioteca;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JScrollPane scrollPane;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//test
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JBiblioteca frame = new JBiblioteca();
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
	public JBiblioteca() {
		biblioteca = new Biblioteca();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(64, 34, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(462, 34, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(12, 37, 56, 16);
		contentPane.add(lblIsbn);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(394, 37, 56, 16);
		contentPane.add(lblAutor);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(243, 86, 116, 25);
		contentPane.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 124, 600, 167);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"AUTOR", "ISBN", "TITULO"
			}
		));
		scrollPane.setViewportView(table);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Añadir(biblioteca).setVisible(true);
			}
		});
		btnNuevo.setBounds(64, 304, 97, 25);
		contentPane.add(btnNuevo);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEliminar.setBounds(262, 304, 97, 25);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Modificar(biblioteca).setVisible(true);
				
			}
		});
		btnModificar.setBounds(430, 304, 109, 25);
		contentPane.add(btnModificar);
		
		biblioteca.recuperarLibros();
		cargarTabla();
	}
	
	private void cargarTabla() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for ( Libro a : biblioteca.getEstanteria() ){
			Object[] fila = new Object[table.getModel().getColumnCount()];
			fila[0]= a.getAutor();
			fila[1]= a.getiSBN();
			fila[2]= a.getTitulo();
			model.addRow(fila);
		}
		
	}
}