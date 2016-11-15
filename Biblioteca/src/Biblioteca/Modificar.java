package Biblioteca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfISBN;
	private JTextField tfAutor;
	private JTextField tfTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modificar dialog = new Modificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modificar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLibro = new JLabel("LIBRO");
		lblLibro.setBounds(172, 11, 46, 14);
		contentPanel.add(lblLibro);
		
		tfISBN = new JTextField();
		tfISBN.setEditable(false);
		tfISBN.setBounds(135, 71, 86, 20);
		contentPanel.add(tfISBN);
		tfISBN.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(135, 124, 86, 20);
		contentPanel.add(tfAutor);
		tfAutor.setColumns(10);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(135, 175, 86, 20);
		contentPanel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(26, 74, 46, 14);
		contentPanel.add(lblIsbn);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(26, 127, 46, 14);
		contentPanel.add(lblAutor);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(26, 178, 46, 14);
		contentPanel.add(lblTitulo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btModificar = new JButton("Modificar");
				btModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String ISBN = tfISBN.getText().toString();
						String autor = tfAutor.getText().toString();
						String titulo = tfTitulo.getText().toString();
						Libro lb1 = new Libro(ISBN,autor,titulo);
						Biblioteca.modificarLibros(lb1);
					}
				});
				btModificar.setActionCommand("OK");
				buttonPane.add(btModificar);
				getRootPane().setDefaultButton(btModificar);
			}
		}
	}
}
