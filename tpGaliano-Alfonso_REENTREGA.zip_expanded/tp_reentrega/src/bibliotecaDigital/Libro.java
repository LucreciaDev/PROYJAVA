package bibliotecaDigital;

public class Libro {
	private String codigoISBN;
	private String titulo;
	private String categoria;
	private double ancho;
	
	public Libro(String ISBN,String categoria,String titulo,double elAncho){
		//es el contructor del libro
		if(ISBN.length()==10 || ISBN.length()==13){
			this.codigoISBN=ISBN;
		}
		else {
			throw new RuntimeException("El isbn no es valido");
		}
		
		if(titulo.length()>0){
			this.titulo=titulo;
		}
		else {
			throw new RuntimeException("El titulo no es valido");
		}
		
		if(categoria.length()>0){
			this.categoria=categoria;
		}
		else {
			throw new RuntimeException("La categoria no es valida");
		}
		
		if(elAncho>0) {
			this.ancho=elAncho;
		}
		else {
			throw new RuntimeException("El tamaño no es valido");
		}
	}
	
	//Getters
	
	public String getISBN() {
		return codigoISBN;
	}

	public String getCategoria() {
		return categoria;	
	}

	public String getTitulo() {
		return titulo;
	}

	public double getAncho() {
		return ancho;	
	}
	
	@Override
	public String toString() {
		return "|" + codigoISBN + ", " + titulo + "|";
	}

}