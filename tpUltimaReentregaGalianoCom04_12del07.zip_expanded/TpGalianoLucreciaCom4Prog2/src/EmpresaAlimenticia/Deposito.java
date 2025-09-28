package EmpresaAlimenticia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Deposito {

	//atributos
	private double CapacidadMaxima;//volumenMaximo
	private boolean Propio;
	private boolean Refrigeracion;
	private LinkedList <Paquete> paquete;
	private double CostoPorTonelada;
	private String destino;
	private double descargaDep;
	
	//constructor1
	Deposito(double capacidad, boolean tieneRefrigeracion, boolean propio) {
		setCapacidadMaxima(capacidad);
		Refrigeracion=tieneRefrigeracion;
		Propio=propio;
		paquete=new LinkedList<Paquete>();
		descargaDep=0.0;
	}
	
	//constructor2
	Deposito(double capacidad, boolean tieneRefrigeracion, boolean propio, double costoDeTonelada) {
		setCapacidadMaxima(capacidad);
		Refrigeracion=tieneRefrigeracion;
		Propio=propio;
		paquete=new LinkedList<Paquete>();
		descargaDep=0.0;
		setCostoXtonelada(costoDeTonelada);
	}
	
	//los setters 
	private void setCapacidadMaxima(double n) {
		if(n>0.0) {
			CapacidadMaxima=n;
		}	
	}
	
	private void setCostoXtonelada(double n) {
		if(n>0.0) {
		CostoPorTonelada=n;
		}
	}
	
	//los getters
	public double getCapacidadMaxima() {
		return CapacidadMaxima;
	}
	
	public boolean getRefrigeracionD() {
		return Refrigeracion;
	}
	
	public boolean getPropio() {
		return Propio;
	}
	
	public double getCostoPorTonelada() {
		return CostoPorTonelada;
	}
	
	public String getDestino() {
		return destino;
	}
	
 	public LinkedList <Paquete> getPaquetes(){
		return paquete;
	}
 	
	//metodos
 	public double CostoFinal() {
		return (descargaDep*CostoPorTonelada);
	}
	
	public int cantPaquetes() {
		return paquete.size();
	}

	public void agregarPaquete(String destino, double volumen, double peso, boolean refrigeracionP) {
		Paquete p=new Paquete(peso, volumen, destino, refrigeracionP);
		CapacidadMaxima=CapacidadMaxima-volumen;
		paquete.add(p);
	}
		
	public boolean quitarPaquete(double peso, double volumen, String destino, boolean refrigeracionP) {
		Paquete p=new Paquete(peso, volumen, destino, refrigeracionP);
		if(paquete.contains(p)) {
			Iterator<Paquete> paq=paquete.iterator();
			while(paq.hasNext()){
				if(((Paquete) paq.next()).equals(p)) {
					CapacidadMaxima=CapacidadMaxima+volumen;
					paq.remove();
					return true;
				}	
			}
		}
		return false;
	}
	
	public boolean PaquetesIguales(LinkedList <Paquete> paquetes2) {
		boolean igualdad=true;
		for(Paquete paq1:paquete) {
			for(Paquete paq2:paquetes2) {
				igualdad=igualdad && (paq1.equals(paq2));
			}
		}
		return igualdad;
	}

	public double cargarTransporte(Transporte t) {
		double cargat=0.0;
		Iterator<Paquete> paq=paquete.iterator();
		while(paq.hasNext()){
			Paquete p=(Paquete) paq.next();
			if((t.agregarPaquete(p))) {
				cargat=cargat+p.getVolumen();
				descargaDep=descargaDep+p.getVolumen();
				paq.remove();
			}
		}t.cargarcostoTonelada((cargat/1000)*CostoPorTonelada);
		return cargat;
	}

	@Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Deposito other = (Deposito) obj;
	    return (CapacidadMaxima == other.CapacidadMaxima) && (CostoPorTonelada == other.CostoPorTonelada)
	        && (Propio == other.Propio) && (Refrigeracion == other.Refrigeracion)
	        && (descargaDep == other.descargaDep) && Objects.equals(destino, other.destino) && PaquetesIguales(other.paquete);
	  }

	public String toString() {
		StringBuilder depo = new StringBuilder ();
		depo.append("\n"+"Deposito: ");
		depo.append("\n"+"CapacidadMaxima: " + getCapacidadMaxima());
		if(getRefrigeracionD()) {
			depo.append("\n"+"Tiene refrigeracion");
		}
		if(!getRefrigeracionD()) {
			depo.append("\n"+"No tiene refrigeracion");
		}
		if(!getPropio()) {
			depo.append("\n"+"Es tercerizado");
		}
		if(getPropio()) {
			depo.append("\n"+"No es tercerizado");
		}
		for(Paquete p:paquete) {
			depo.append("\n"+p.toString());
		}
		depo.append("\n"+"Costo por Tonelada"+getCostoPorTonelada());
		return depo.toString();
	}

}