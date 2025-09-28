package bibliotecaDigital;

public class MainBDUNGS {

	public static void main(String[] args){
		
			BDUNGS bd = new BDUNGS(10, 50);
			
			bd.rotularEstante("Computacion", 1);
			bd.rotularEstante("Matematica", 2);
			bd.rotularEstante("Computacion", 3);

			bd.ingresarLibro("9789684443457", "Computacion", "Estructuras de datos", 15);
			bd.ingresarLibro("9788415552222", "Computacion", "Estructuras de datos en Java", 10);
			bd.ingresarLibro("9389557783457", "Matematica", "Analisis de Funciones", 4);

			bd.ingresarLibro("9789684443458", "Computacion", "Estructuras de datos 2", 15);
			bd.ingresarLibro("9788415552223", "Computacion", "Estructuras de datos en Java 1", 10);

			bd.eliminarLibro("9789684443457");
			System.out.println(bd);
			System.out.println(bd.reacomodarCategoria("Computacion"));
			System.out.println(bd);

		}
}
