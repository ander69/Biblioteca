package Biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout.Constraints;




public class Biblioteca {
	final static String nomfich = "Fich06.obj";
	private ArrayList <Libro> estanteria = new ArrayList<Libro>();

	public Boolean añadirLibro(Libro LibroNuevo){
		Boolean dev = false;
		if (estanteria.contains(LibroNuevo)){
			
		}else{
			estanteria.add(LibroNuevo);
			dev = true;	
		}	
		return dev;
	}
	public int archivarLibros(){
		int num= 0;
		FileOutputStream f = null;
		try{
			f = new FileOutputStream(nomfich);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			ObjectOutputStream fis=new ObjectOutputStream(f);
			for (Libro a: estanteria){
				num++;
				fis.writeObject(a);
			}
			fis.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		return num;
	}
	public int recuperarLibros(){
		int num=0;
		File fich = new File (nomfich);
		try{
			if (fich.exists()){
				FileInputStream fe = new FileInputStream(fich);
				ObjectInputStream fie = new ObjectInputStream(fe);
				Libro a = (Libro)fie.readObject();
				while(a!= null){
					num++;
					estanteria.add(a);
					a = (Libro)fie.readObject();
				}
				fie.close();		
			}
		}catch (Exception e){	
			
		}
		return num;	
	}
	public Boolean borraLibro(String iSBN){
		Boolean dev=false;
		int pos;
		for(Libro a: estanteria){
			if (a.getiSBN().equals(iSBN)){
			estanteria.remove(a);
			dev=true;
			}
		}
		return dev;
	}
	public Libro buscarLibroISBN(String iSBN){
		Libro dev = null;
		for(Libro a: estanteria){
			if(a.getiSBN().equals(iSBN)){
				dev = a;
				break;
			}
		}
		return dev;
	}
	public ArrayList <Libro> buscarLibroAutor(String autor){
		ArrayList<Libro> autor1 = new ArrayList<Libro>();
		autor1=null;
		for(Libro a: estanteria){
			if(a.getAutor().equals(autor)){
				autor1.add(a);
			}
		}
		return autor1;	
	}
	public void modificarLibros(Libro LibroModifiar){
		for(Libro a: estanteria){
			if(a.getiSBN().equals(LibroModifiar.getiSBN())){
				estanteria.remove(a);
				estanteria.add(LibroModifiar);	
			}
		}
	}
	public void mostrarLibros(){
		
	}
	public ArrayList<Libro> getEstanteria() {
		return estanteria;
	}
}

