package EmpresaAlimenticia;

class CamionMegaTrailer extends Transporte{
	
	//atributos
	protected double CostoFijo;
	protected double comidaCamionero;
		
	//constructor
	CamionMegaTrailer(String id, double carga, boolean refri,double capacidad,double costoXkm, double seguro,double costoFijo,double comida){
	super(id, carga, capacidad, refri, costoXkm, seguro,"CamionMegaTrailer");
		setComidaCamionero(comida);
		setCostoFijo(costoFijo);
	}
	
	//setter
	public void setComidaCamionero(double comida) {
		if(comida>0.0) {
		comidaCamionero=comida;
		}
	}
	
	public void setCostoFijo(double costo) {
		if(costo>0.0) {
		comidaCamionero=costo;
		}
	}
	
	//metodo
	public String Tipo() {
		return super.Tipo();
	}
	

	public double costoFinal() {
		return super.costoFinal() + CostoFijo + comidaCamionero;
	}
	
}
