package Biblioteca;


import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField tfISBN;
	private JTextField tfAutor;
	private static JTable table;
	private static Biblioteca biblioteca;
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
		
		tfISBN = new JTextField();
		tfISBN.setBounds(64, 34, 116, 22);
		contentPane.add(tfISBN);
		tfISBN.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(462, 34, 116, 22);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(12, 37, 56, 16);
		contentPane.add(lblIsbn);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(394, 37, 56, 16);
		contentPane.add(lblAutor);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				String isbn = tfISBN.getText().toString();
				String autor = tfAutor.getText().toString();
				if(isbn.isEmpty() && autor.isEmpty()){
					cargarTabla();
					
				}else{
					if(autor.isEmpty()){
						System.out.println("aqui");
						Libro a=Biblioteca.buscarLibroISBN(isbn);
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						Object[] fila = new Object[table.getModel().getColumnCount()];
						fila[0]= a.getAutor();
						fila[1]= a.getiSBN();
						fila[2]= a.getTitulo();
						model.addRow(fila);
					}else if(isbn.isEmpty()){
						
						ArrayList<Libro> autor1 = new ArrayList<Libro>();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						autor1=Biblioteca.buscarLibroAutor(autor);
						for ( Libro a : autor1 ){
							Object[] fila = new Object[table.getModel().getColumnCount()];
							fila[0]= a.getAutor();
							fila[1]= a.getiSBN();
							fila[2]= a.getTitulo();
							model.addRow(fila);
						}
					}
					
				}
				
			}
		});
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
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String isbn = (String)model.getValueAt(table.getSelectedRow(), 1);
				model.removeRow(table.getSelectedRow());
				Biblioteca.borraLibro(isbn);
				Biblioteca.archivarLibros();
			}
		});
		btnEliminar.setBounds(262, 304, 97, 25);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				if(table.getSelectedRow() == -1){
					JOptionPane.showMessageDialog(null, "selecciona una fila");
				}else{
					String isbn = (String)model.getValueAt(table.getSelectedRow(), 1);
					String autor = (String)model.getValueAt(table.getSelectedRow(), 0);
					String titulo = (String)model.getValueAt(table.getSelectedRow(), 2);
					new Modificar ().tfISBN.setText(isbn);
					
				}
				
			}
		});
		btnModificar.setBounds(430, 304, 109, 25);
		contentPane.add(btnModificar);
		
		biblioteca.recuperarLibros();
		cargarTabla();
	}
	
	public static void cargarTabla() {
		limpiar();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for ( Libro a : biblioteca.getEstanteria() ){
			Object[] fila = new Object[table.getModel().getColumnCount()];
			fila[0]= a.getAutor();
			fila[1]= a.getiSBN();
			fila[2]= a.getTitulo();
			model.addRow(fila);
		}
		
	}
	public static void limpiar(){
		int fila;
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		fila=model.getRowCount();
		for(int i = 0;i<fila;i++){
			model.removeRow(0);
		}
		
		
	}
}