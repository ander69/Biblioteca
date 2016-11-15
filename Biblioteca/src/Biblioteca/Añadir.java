package Biblioteca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Añadir extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfISBN;
	private JTextField tfAutor;
	private JTextField tfTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Añadir dialog = new Añadir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Añadir() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblLibro = new JLabel("LIBRO");
			lblLibro.setBounds(178, 11, 46, 14);
			contentPanel.add(lblLibro);
		}
		{
			JLabel lblIsbn = new JLabel("ISBN");
			lblIsbn.setBounds(47, 66, 46, 14);
			contentPanel.add(lblIsbn);
		}
		{
			JLabel lblAutor = new JLabel("Autor");
			lblAutor.setBounds(47, 122, 46, 14);
			contentPanel.add(lblAutor);
		}
		{
			JLabel lblTitulo = new JLabel("Titulo");
			lblTitulo.setBounds(47, 172, 46, 14);
			contentPanel.add(lblTitulo);
		}
		{
			tfISBN = new JTextField();
			tfISBN.setBounds(153, 63, 86, 20);
			contentPanel.add(tfISBN);
			tfISBN.setColumns(10);
		}
		{
			tfAutor = new JTextField();
			tfAutor.setBounds(153, 119, 86, 20);
			contentPanel.add(tfAutor);
			tfAutor.setColumns(10);
		}
		{
			tfTitulo = new JTextField();
			tfTitulo.setBounds(153, 166, 86, 20);
			contentPanel.add(tfTitulo);
			tfTitulo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btAñadir = new JButton("A\u00F1adir");
				btAñadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Boolean esta;
						String ISBN = tfISBN.getText().toString();
						String autor = tfAutor.getText().toString();
						String titulo = tfTitulo.getText().toString();
						Libro lb1 = new Libro(ISBN,autor,titulo);
						esta=Biblioteca.añadirLibro(lb1);
						tfISBN.setText("");
						tfAutor.setText("");
						tfTitulo.setText("");
						if (esta == true){
							JOptionPane.showMessageDialog(null, "Añadido correctamente");
							
						}else{
							JOptionPane.showMessageDialog(null, "Error, El arbol ya estaba añadido");
						}

					}
				});
				btAñadir.setActionCommand("OK");
				buttonPane.add(btAñadir);
				getRootPane().setDefaultButton(btAñadir);
			}
		}
	}

}
