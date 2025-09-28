package bibliotecaDigital;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Estante {
	private String rotulo;//es el nombre de la categoria que contiene
	private double tamanio;
	private double espacioLibre;//sera el que tambien contenga el valor del estante pero este sera el que modificaremos czada vez que se ingrese o se quite un libro
	private LinkedList <Libro> libros;
	
	public Estante(String categoria, double anchoDelEstante){
		this.rotulo = categoria;
		if (anchoDelEstante>0) {
			this.tamanio = anchoDelEstante;
			this.espacioLibre = anchoDelEstante;
		}
		this.libros = new LinkedList<Libro>();
	}
	
	public void eliminarLibro(String isbn) {
		Iterator<Libro> it=libros.iterator();
		while (it.hasNext()) {
			Libro l = it.next(); 
			//Se requiere para poder agregar correctamente su ancho al espacio libre
			if (l.getISBN().equals(isbn)) {
				this.espacioLibre= this.espacioLibre + l.getAncho();
				it.remove();
			}
		}
	}
	
	public void guardarLibro(String elISBN, String categoria, String titulo,double ancho){
		Libro elLibro=new Libro(elISBN, categoria, titulo, ancho);
		libros.add(elLibro);
		this.espacioLibre=this.espacioLibre-ancho;
	}
	
	public boolean estaVacio() {
		return this.espacioLibre==this.tamanio && libros.isEmpty();
	}
	
	public String getISBNDeLibro(int f) {
		return libros.get(f).getISBN();
	}
	
	public void setRotulo(String categoria){
		if(rotulo==null && estaVacio()) {
			this.rotulo=categoria;
		}
		else {
			throw new RuntimeException("Este estante ya posee rotulo");
		}
	}

	public String getRotulo(){
		return rotulo;
	}
	
	public double getTamanio(){
		return tamanio;
	}
	
	public double getEspacioLibre(){
		return espacioLibre;
	}	
	
	public HashMap<String, Integer> verLibros(){
		HashMap<String, Integer> apariciones =new HashMap<String, Integer>();
		
		Iterator<Libro> it=this.libros.iterator();
		while (it.hasNext()) {
			Libro l = it.next();
			if(!(apariciones.containsKey(l.getISBN()))){
				apariciones.put(l.getISBN(), 1);
			}else{
				apariciones.replace(l.getISBN(), apariciones.get(l.getISBN())+1);
			}
		}	
		return apariciones;
	}
	
	public void reacomodarLibros(Estante e2) {
		Iterator<Libro> it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
			if (e2.getEspacioLibre()-l.getAncho()>0) {
				e2.guardarLibro(l.getISBN(), l.getCategoria(), l.getTitulo(), l.getAncho());
				this.espacioLibre=this.espacioLibre+l.getAncho();
				libros.remove(l);
			}
		}
	}
	
	public boolean tieneMasEspacioQue(Estante e2){
		if(this.espacioLibre>e2.espacioLibre){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.rotulo + ", " + this.tamanio);
		if(libros.isEmpty()) {
			s.append(", no posee libros actualmente");
		}else {
			s.append(", posee los siguientes libros: \n");
			for (Libro libro: this.libros) {
				s.append(libro.toString() + "\n");
				}
		}
		return s.toString();
	}

}