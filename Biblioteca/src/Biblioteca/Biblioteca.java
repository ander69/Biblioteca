package Biblioteca;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Biblioteca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//test
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca frame = new Biblioteca();
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
	public Biblioteca() {
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
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(243, 86, 116, 25);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
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
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(64, 304, 97, 25);
		contentPane.add(btnNuevo);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(262, 304, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(430, 304, 109, 25);
		contentPane.add(btnModificar);
	}
}