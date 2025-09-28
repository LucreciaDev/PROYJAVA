package EmpresaAlimenticia;

import java.util.LinkedList;

class Flete extends Transporte{
	
	//atributos
	protected LinkedList<String> pasajeros;
	protected double costoPasaje;
	
	//constructor
	Flete(String id, double carga, double capacidad, double costoXkm, int acompaniantes, double costoPasaje) {
		super(id, carga, capacidad, false, costoXkm, 0, "Flete");//el cero es porque no tiene seguro de carga
		setPasajeros(acompaniantes);
		setCostoPasaje(costoPasaje);
	}
	
	//los setters
	private void setCostoPasaje(double costoP){
		if(costoP>0) {
			costoPasaje=costoP;
		}	
	}
	
	public void setPasajeros(int cant) {
		pasajeros=new  LinkedList<String>();
		for(int i=0;i<cant;i++) {
			pasajeros.add("Acompañante"+(i+1));
		}
	}
	
	//los getters
	public LinkedList<String> getPasajeros(){
		return pasajeros;
	}
	
	public double getCostoPasaje() {
		return costoPasaje;
	}
	
	public String Tipo() {
		return super.Tipo();
	}
	
	//metodos:
	public int cantAcompañantes() {
		return pasajeros.size();
	}
	
	public double costoFinal() {
		return super.costoFinal()+(cantAcompañantes()*getCostoPasaje());
	}

	@Override
	public String toString() {
		StringBuilder lospasajeros = new StringBuilder ();
		for(String p:pasajeros) {
			lospasajeros.append("\n"+p+" - ");
		}
		return super.toString()+ getPasajeros() +"costo del pasaje"+ getCostoPasaje() +
				lospasajeros;
	}
	
}
