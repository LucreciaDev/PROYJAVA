package EmpresaAlimenticia;

public class Paquete {
	
	//atributos
	private double Peso;//carga
	private double Volumen;//capacidad
	private String Destino;
	private boolean RefrigeracionP;
		
	//constructor
	Paquete(double peso, double volumen, String dest, boolean refrigeracionP) {
			setPeso(peso);
			setVolumen(volumen);
			setDestino(dest);					
			RefrigeracionP= refrigeracionP;			
	}
	
	//los setters
	private void setPeso(double p) {
	 	if(p<0) {
	 		throw new RuntimeException("Cargue un peso correcto");
		}
	 	Peso=p;
	}
		
	private void setVolumen(double v) {
	 	if(v<0) {
	 		throw new RuntimeException("Cargue un volumen correcto");
		}
	 	Volumen=v;
	}
		
	private void setDestino(String destin0){
		if(destin0.length()>0 && destin0!=null) {
			Destino=destin0;
		}
	}
	
	//los getters
	public double getPeso() {
		return Peso;
	}
		
	public double getVolumen() {
		return Volumen;
	}
		
	public String getDestino() {
		return Destino;
	}
		
	public boolean getRefrigeracionP() {
		return RefrigeracionP;
	}
		
	@Override
	public boolean equals(Object obj) {
			if ((this == null) || (obj == null))
				return false;
			Paquete other = (Paquete) obj;
			return getDestino().equals(other.getDestino()) &&(getPeso() == other.getPeso()) && (getRefrigeracionP() == other.getRefrigeracionP()) && (getVolumen() == other.getVolumen());
		}

	@Override
	public String toString() {
		StringBuilder paqs = new StringBuilder ();
		paqs.append("El paquete pesa: "+getPeso()+"; ");
		paqs.append("tiene un volumen de: "+getVolumen()+"; ");
		paqs.append("se lo envia a "+Destino);
		if(getRefrigeracionP()) {
		paqs.append("y requiere frio. ");
		}paqs.append("y no requiere frio. ");
	return paqs.toString();
	}
	
}