package EmpresaAlimenticia;

class Prueba {

	public static void main(String[] args) {
	Empresa emp;
	  double carga, ctoViaje;
	  
	  emp = new Empresa("30112223334","La Santafesina");
	  emp.agregarDestino("Cordoba", 350);
	  emp.agregarDestino("Corrientes", 900);
	  emp.agregarDestino("Parana", 30);
	  
	  emp.agregarDeposito(30000, false, false);
	  emp.agregarDepTercerizFrio(80000, 50);
	  emp.agregarTrailer("AC314PI", 12000, 60, true, 5, 100);
	  emp.asignarDestino("AC314PI", "Cordoba");
	  emp.incorporarPaquete("Cordoba", 100, 5, true);
	  emp.incorporarPaquete("Cordoba", 250, 10, true);
	  emp.incorporarPaquete("Cordoba", 150, 8, true);
	  emp.incorporarPaquete("Cordoba", 50, 2.5, false);
	  emp.incorporarPaquete("Cordoba", 300, 15, true);
	  emp.incorporarPaquete("Cordoba", 400, 12, true);
	  emp.incorporarPaquete("Cordoba", 125, 5, false);
	  carga = emp.cargarTransporte("AC314PI");
	  ctoViaje = emp.obtenerCostoViaje("AC314PI");
	  System.out.println();
	  System.out.println(emp.toString());
	  System.out.println();
	  System.out.println("la carga es de "+carga);
	  System.out.println();
	  System.out.println("el cto de viaje es de "+ctoViaje);
	}
}
