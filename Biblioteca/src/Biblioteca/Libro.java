package Biblioteca;

import java.io.Serializable;



public class Libro implements Serializable{
	private String autor;
	private String titulo;
	private String iSBN;
	
	public Libro(String iSBN){
		this.iSBN=iSBN;
		
	}
	public Libro(String autor,String titulo, String iSBN){
		this.autor=autor;
		this.titulo=titulo;
		this.iSBN=iSBN;
		
	}
	@Override
	public String toString() {
		return autor.toLowerCase()+","+titulo.toLowerCase()+","+iSBN.toLowerCase();
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((iSBN == null) ? 0 : iSBN.hashCode());
		
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (iSBN == null) {
			if (other.iSBN != null)
				return false;
		} else if (!iSBN.equals(other.iSBN))
			return false;
		return true;
	}
	

}
