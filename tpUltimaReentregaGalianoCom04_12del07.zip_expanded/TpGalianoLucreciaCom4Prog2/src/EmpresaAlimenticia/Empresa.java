package EmpresaAlimenticia;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Objects;

public class Empresa{
	
	private String CUIT;
	private String Nombre;
	
	public LinkedList <Deposito> depositos;
	public HashMap<String, Transporte> transportes;
	
	public HashMap<String, Integer> destinos;
	
	Empresa(String cuit,String nombre){
		setId(cuit);
		setNombre(nombre);
				
		depositos=new LinkedList <Deposito>();
		transportes=new HashMap<String, Transporte>();
		destinos=new HashMap<String, Integer>();	
	}
	
	//Setters
	private void setId(String d) {
		if(6<d.length() && d != null) {
			CUIT= d;
		}
	}
	
	private void setNombre(String d) {
		if(0<d.length() || d != null) {
			Nombre= d;
		}
	}
	
	//getters
	private String getId() {
		return CUIT;
	}
	
	private String getNombre() {
		return Nombre;
	}
	
	//metodos
	public boolean incorporarPaquete(String destino, double volumen, double peso, boolean frio) {
		for (Deposito dep : depositos) {
			if((dep.getCapacidadMaxima()>=volumen) && (dep.getRefrigeracionD()==frio)) {
				dep.agregarPaquete(destino, peso, volumen, frio);
				return true;
			}
		}
		return false;
	}
	
	public void agregarDestino(String destino, int km) {
		if(!destinos.containsKey(destino) && (km>0) && (destino.length()>0)) {
			destinos.put(destino, km);
		}
	}
	
	public int agregarDepTercerizFrio(double capacidad, double costoPorTonelada) {
		Deposito dtf=new Deposito(capacidad, true, false, costoPorTonelada);
		depositos.add(dtf);
		return depositos.size()-1;
	}
	
	public int agregarDeposito(double capacidad, boolean frigorifico, boolean propio) {
		 Deposito d=new Deposito(capacidad, frigorifico, propio);
		 depositos.add(d);	
		 return depositos.size()-1;
	 }

	public void agregarTrailer(String idTransp, double cargaMax, double capacidad, boolean frigorifico, double costoKm, double segCarga) {
		transportes.put(idTransp,new CamionTrailerComun(idTransp, cargaMax, capacidad, frigorifico, costoKm, segCarga));
	}
	
	public void agregarMegaTrailer(String idTransp, double cargaMax, double capacidad, boolean frigorifico, double costoKm, double segCarga, double costoFijo, double comida) {
		transportes.put(idTransp,new CamionMegaTrailer(idTransp, cargaMax, frigorifico, capacidad, costoKm, segCarga, costoFijo, comida));
	}
	
	public void agregarFlete(String idTransp, double cargaMax, double capacidad, double costoKm, int acomp, double costoPorAcom) {
		transportes.put(idTransp,new Flete(idTransp, cargaMax, capacidad, costoKm, acomp, costoPorAcom));
	}
	
	public void asignarDestino(String vehiculo, String destino) {
		if(destinos.containsKey(destino) && transportes.containsKey(vehiculo)){
			if(transportes.get(vehiculo).cantPaquetes()>0) {
				throw new RuntimeException("No se le puede cargar destino al transporte");
			}
			if((destinos.get(destino)>500) && transportes.get(vehiculo).Tipo().equals("CamionMegaTrailer")) {
				transportes.get(vehiculo).asignarDestino(destino, destinos.get(destino));
			}
			transportes.get(vehiculo).asignarDestino(destino, destinos.get(destino));
		}
	}
	
	public String obtenerTransporteIgual(String id) {
		for (Transporte t :transportes.values()) {
		      if((!id.equals(t.getIdentificacion())) && t.equals(transportes.get(id))){
		    	  return t.getIdentificacion();
		      }
		   }
		return null;
	}
	
	
	public  double cargarTransporte(String id) {
		//en este caso considero que todos los depositos se encuentran en un mismo terreno
		//ya que esto no esta aclarado en el tp en que lugar se encuentran 
		if(transportes.containsKey(id)) {
		Transporte transpAcargar = transportes.get(id);
		if(transpAcargar.viajando() || (transpAcargar.getDestino()==null || transpAcargar.getDestino().length()<=0 )){
			throw new RuntimeException("El transporte esta en viaje");
		}else if(transpAcargar.getDestino().length()>0){
			double cargaVehiculo=0.0;
			for(Deposito dep:depositos) {
				if((dep.getRefrigeracionD() == transpAcargar.getRefrigeracionT())) {
					cargaVehiculo=cargaVehiculo+ dep.cargarTransporte(transpAcargar);
				}					
			}return cargaVehiculo;
		}
		}return 0.0;
	}

		
	public double obtenerCostoViaje(String id) {
		/*como vera tuve que castear igual lo intente sin cateo pero no funciona.
		 Me llamo la atecion por todo lo hablado pero bueno se ve que debe ser casteado igual por el hecho
		 de que son varias clases extendes de Transporte y eso que Transorte la hice public abstrac raro. */
		if(transportes.containsKey(id)) {
		if(transportes.get(id).Tipo().equals("Flete")) {
			return ((Flete)transportes.get(id)).costoFinal();
		}
		else if(transportes.get(id).Tipo().equals("CamionMegaTrailer")) {
			return ((CamionMegaTrailer)transportes.get(id)).costoFinal();
		}
			return transportes.get(id).costoFinal();
		}return 0.0;
	}
	
	public void iniciarViaje(String idTransp) {
		if(transportes.containsKey(idTransp)) {
		transportes.get(idTransp).activarViaje();
		}
	}

	public void finalizarViaje(String idTransp) {
		if(transportes.containsKey(idTransp)) {
		transportes.get(idTransp).desactivarViaje();
		}
	 }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return getId().equals(other.getId()) && getNombre().equals(other.getNombre()) && Objects.equals(depositos, other.depositos) && Objects.equals(destinos, other.destinos)
			&& Objects.equals(transportes, other.transportes);
	}

	@Override
	public String toString() {
		StringBuilder transp = new StringBuilder ("***************************************************************************"+"\n"+"\n");
		transp.append("Empresa=" + CUIT +"/"+ "Nombre=" + Nombre +"\n"+"\n");
		transp.append("------------");
		for(Deposito d:depositos) {
			transp.append(d.toString());
		}
		transp.append("\n"+"\n");
		transp.append("-------------------");
		for(Transporte t:transportes.values()) {
			transp.append(t.toString());
		}
		transp.append("\n"+"\n");
		transp.append("-------------------");
		return transp.toString();
	}

}
