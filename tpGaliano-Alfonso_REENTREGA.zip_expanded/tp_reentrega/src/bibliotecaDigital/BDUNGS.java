package bibliotecaDigital;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class BDUNGS {
	private LinkedList <Estante> estantes;
	
	public BDUNGS(int cantEstantes, double tamanio) {
		this.estantes= new LinkedList <Estante>();
		for(int i=0;i<cantEstantes;i++){
			Estante nuevo= new Estante(null,tamanio);
			this.estantes.add(nuevo);
		}
	}

	public void rotularEstante(String categoria, int i) {
		if (estantes.get(i).getRotulo()==null) {
			estantes.get(i).setRotulo(categoria);//le modifica el rotulo
		}
		else {
			throw new RuntimeException("No es posible rotular este estante");
		}
	}

	public boolean ingresarLibro(String isbn, String cat, String titulo, int ancho) {
		if(!existeCategoria(cat)) {
			throw new RuntimeException("No existe ningun estante con dicha categoria");			
		}else {
			for (Estante est: estantes) {
				if (est.getRotulo()==cat) {
					if(est.getEspacioLibre()>=ancho) {
						est.guardarLibro(isbn, cat, titulo, ancho);
						return true;
					}	
				}
			}
		}
		return false;	
	}

	public double espacioLibre(int i) {
		if (estantes.get(i).getRotulo()!=null){
			return estantes.get(i).getEspacioLibre();
		}else{
			throw new RuntimeException("No esta rotulado");
		}
	}
	
	public HashMap<String, Integer> verLibrosCategoria(String categoria) {
		HashMap<String, Integer> librosEnCategoria =new HashMap<String, Integer>();
		if(!existeCategoria(categoria)) {
			throw new RuntimeException("No se encuentra dicha categoria");
		}else{
			for (Estante est: this.estantes) {
				if (est.getRotulo()==categoria) {
					librosEnCategoria.putAll(est.verLibros());
					//el verLibro() retorna un hashMap, por eso se puede agregar a librosEnCategoria
				}
			}
			return librosEnCategoria;
		}
	}

	public void eliminarLibro(String isbn) {
		Iterator<Estante> it=estantes.iterator();
		while (it.hasNext()) {
			it.next().eliminarLibro(isbn);
		}
	}
	
	public int reacomodarCategoria(String categoria) {
		int cont=0;
		if(!existeCategoria(categoria)) {
			throw new RuntimeException("No se encuentra dicha categoria");
		}
		else {
			Estante masVacio=estantesDeCategoria(categoria).getLast();
			for (Estante est: estantesDeCategoria(categoria)) {
				if(!est.equals(masVacio))
					if(masVacio.tieneMasEspacioQue(est))
						masVacio.reacomodarLibros(est);
					else
						est.reacomodarLibros(masVacio);
			}
			if (masVacio.estaVacio()) {
				cont++;
			}
		}
		return cont;
	}
 
	private boolean existeCategoria(String categoria) {
		boolean ret=false;
		for (Estante est: this.estantes) {
			ret = ret || est.getRotulo()==categoria;
		}
		return ret;
	}
	
	private LinkedList<Estante> estantesDeCategoria(String cat){
		LinkedList<Estante> estantesCat = new LinkedList<Estante>();
		for (Estante est: this.estantes) {
			if (est.getRotulo()==cat) {
				estantesCat.add(est);
			}
		}
		return estantesCat;
	}

	@Override
	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append("Biblioteca Digital, posee los siguientes estantes: \n");
		for(Estante est: this.estantes) {
			if (est.getRotulo()!=null) {
				s.append(est.toString()+ "\n");
			}
		}
		return s.toString();
	}
	
}