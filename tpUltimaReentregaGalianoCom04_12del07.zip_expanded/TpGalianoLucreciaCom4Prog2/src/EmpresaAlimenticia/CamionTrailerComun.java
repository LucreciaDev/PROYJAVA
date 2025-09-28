package EmpresaAlimenticia;

class CamionTrailerComun extends Transporte{
	//constructor
	CamionTrailerComun(String id, double carga,double capacidad, boolean refri,double costoXkm,double seguro) {	
		super(id, carga, capacidad, refri, costoXkm, seguro,"CamionTrailerComun");
	}

	//metodos
	public String Tipo() { 
		return super.Tipo();
	}
	
	@Override
	public double costoFinal() {
		return super.costoFinal();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}