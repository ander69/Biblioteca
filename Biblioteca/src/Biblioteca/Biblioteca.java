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

import Arbol.Arbol;
import Arbol.JFrameArbol;










public class Biblioteca {
	final static String nomfich = "Fich06.obj";
	static ArrayList<Libro> estanteria = new ArrayList<Libro>();

	static Boolean añadirLibro(Object LibroNuevo){
		Boolean dev = false;
		//DUDA
		for(Libro a : estanteria){
			if (LibroNuevo.equals(a.getClass())){
				dev=true;
			}
		}
		if(dev == true){
		estanteria.add((Libro) LibroNuevo);
		}
		
		
		return dev;
		
	}
	static int archivarLibros(){
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
	static int recuperarLibros(){
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
	static Boolean borraLibro(String iSBN){
		Boolean dev=false;
		int pos;
		for(Libro a: estanteria){
			if (a.getiSBN().equals(iSBN)){
			pos=estanteria.indexOf(a);
			dev=true;
			}
		}
		Libro.remove(estanteria.get(pos));
	
		return dev;
	}
	static void buscarLibro(){
		
	}
	static void modificarLibros(){
		
	}
	static void mostrarLibros(){
		
	}
}

