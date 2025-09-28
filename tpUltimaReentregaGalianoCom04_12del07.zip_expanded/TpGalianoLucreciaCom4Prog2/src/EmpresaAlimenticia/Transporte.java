package EmpresaAlimenticia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Transporte{

	//atributos	
	private String Identificacion;//el numero de identificacion del trasporte
	private double CargaMaxima;//el peso
	private double CapacidadMaxima;//volumen
	private boolean Refrigeracion;//puede tener o no por eso elijo boolean
	private double CostoPorKmDeViaje;
	private double seguroCarga;
	private String Destino;
	private String tipo;
	private int kmDestino;
	private boolean enViaje;
private double costoTonelada;
	private LinkedList <Paquete> paquete;
	
	//CONSTRUCTOR:
	Transporte(String id, double cargaT, double capacidad, boolean refri, double costoXkm, double seguro,String tipoVehiculo) {
		setId(id);
		setCargaMaxima(cargaT);//Habla de peso
		setCapacidadMaxima(capacidad);//Habla de volumen
		Refrigeracion=refri;
		setCostoPorKmDeViaje(costoXkm);
		setSeguroCarga(seguro);
		Destino=null;
		enViaje=false;
		tipo=tipoVehiculo;
		kmDestino=0;
		paquete=new LinkedList <Paquete>();
		costoTonelada=0.0;
	}
		
	//LOS SETTERS:
	private void setId(String d) {
		if(6<d.length() && d != null) {
			Identificacion= d;
		}
	}

	private void setCargaMaxima(double n) {
		if(n>0.0) {
			CargaMaxima=n;
		}	
	}

	private void setCapacidadMaxima(double n) {
		if(n>0.0) {
			CapacidadMaxima=n;
		}	
	}
	
	public void setCostoPorKmDeViaje(double costoXkm) {
		CostoPorKmDeViaje=costoXkm;
	}
	
	public void setSeguroCarga(double seguro) {
		seguroCarga=seguro;
	}
	
	private void setDestino(String d) {
		if(0<d.length() && d != null) {
			Destino= d;
		}
	}
	
	public void setKmDestino(int km) {
		kmDestino=km;
	}
	
	public void cargarcostoTonelada(double c) {
		costoTonelada=c;
	}
	//los getters
	public String getIdentificacion() {
		return Identificacion;
	}
		
	public double getCargaMaxima() {
		return CargaMaxima;
	}
	
	public double getCapacidadMaxima() {
		return CapacidadMaxima;
	}
	
	public boolean getRefrigeracionT() {
		return Refrigeracion;
	}

	public double getCostoPorKmDeViaje() {
		return CostoPorKmDeViaje;
	}

	public double getSeguroCarga() {
		return seguroCarga;
	}

	public LinkedList<Paquete> getPaquetes() {
		return paquete;
	}

	public String getDestino() {
		return Destino;
	}
	
	public String Tipo() {
		return tipo;
	}
	
	public int getKmDestino() {
		return kmDestino;
	}
	
	public boolean viajando() {
		return enViaje;
	}
	
	public double costoTonelada() {
		return costoTonelada;
	}
	
	//metodos	
	public boolean agregarPaquete(String destino, double volumen, double peso, boolean refrigeracionP) {
		Paquete p=new Paquete(peso, volumen, destino, refrigeracionP);
		return agregarPaquete(p);
	}
	
	public boolean agregarPaquete(Paquete p) {
		if((getCapacidadMaxima() >= p.getVolumen()) && p.getDestino().equals(getDestino())) {
			CapacidadMaxima=getCapacidadMaxima()-p.getVolumen();
			CargaMaxima=getCargaMaxima()-p.getPeso();
			return paquete.add(p);
		}
		return false;
	}
		
	public boolean quitarPaquete(double peso, double volumen, String destino, boolean refrigeracionP) {
		Paquete p=new Paquete(peso, volumen, destino, refrigeracionP);
		if(paquete.contains(p)) {
			Iterator<Paquete> paq=paquete.iterator();
			while(paq.hasNext()){
				if(((Paquete) paq.next()).equals(p)) {
					CapacidadMaxima=getCapacidadMaxima()+volumen;
					CargaMaxima=getCargaMaxima()+peso;
					paq.remove();
					return true;
				}	
			}
		}
		return false;
	}
	
	public int cantPaquetes() {
		return paquete.size();
	}
	
	public void asignarDestino(String destino, Integer km) {
		setDestino(destino);
		setKmDestino((int)km);
	}

	public double costoFinal() {
		return (kmDestino * CostoPorKmDeViaje)+ seguroCarga+costoTonelada();
	}
	
	public void activarViaje() {
	if(viajando()) {
		throw new RuntimeException("No se puede iniciar viaje, ya esta en viaje");
	}
	if(getDestino()==null) {
		throw new RuntimeException("No se puede iniciar viaje, no tiene destino");
	}
	if(cantPaquetes()<=0) {
		throw new RuntimeException("No se puede iniciar viaje, esta vacio");
	}
			enViaje=true;
		}
	
	public void desactivarViaje() {
		paquete=null;
		Destino=null;
		enViaje=false;
	}
	
	public boolean PaquetesIguales(LinkedList <Paquete> paquetes2) {
		boolean igualdad=true;
		for(int p=0;p<paquete.size();p++) {
			for(Paquete paq2:paquetes2) {
				igualdad=igualdad && (paquete.get(p).equals(paq2));
			}
		}
		return igualdad;
	}

	@Override
	public boolean equals(Object obj) {
		if ((this == null) || (obj == null))
			return false;
		Transporte other = (Transporte) obj;
		return Objects.equals(Destino, other.Destino) && Refrigeracion == other.Refrigeracion
				&& PaquetesIguales(other.paquete)
				&& Objects.equals(tipo, other.tipo);
	}
	
	@Override
	public String toString() {
		StringBuilder transp = new StringBuilder ();
		transp.append("\n"+ Tipo());
		transp.append("\n"+"EnViaje: " + viajando());
		transp.append("\n"+"Identificacion: " + getIdentificacion());
		transp.append("\n"+"SeguroCarga: " + getSeguroCarga());
		transp.append("\n"+"Destino: " + getDestino());
		transp.append("\n"+"KmDestino: " + getKmDestino());
		if(getRefrigeracionT()) {
			transp.append("\n"+"Tiene refrigeracion");
		}
		if(!getRefrigeracionT()) {
			transp.append("\n"+"No tiene refrigeracion");
		}
		transp.append("\n"+"la carga maxima es= "+ getCargaMaxima());
		transp.append("\n"+"la capacidad maxima es= "+ getCapacidadMaxima());
		transp.append("\n"+"Paquetes:");
		for(Paquete p:paquete) {
			transp.append("\n"+p.toString());
		}
		return transp.toString();
	}
}