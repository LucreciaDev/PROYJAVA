package juego;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

import java.awt.*;
import java.util.ArrayList;

import clase.PointRectangle;

public class Juego extends InterfaceJuego {
	static final String RUTA_IMAGENES = "imagenes/"; // es la carpeta donde se encuentran las imagenes
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	Plataforma[] plataforma;
	Mago mago;
	Monstruo[] monstruo;
	ArrayList<Disparo> disparos;
	Image fondo, imgCorazon;
	double tiempo;
	int hecLanzados;
	double puntos;
	int monstruosVivos, vidas;
	boolean pause;

	Rectangle tablero;

	Juego() {
		int anchoEntorno = 500;
		int altoEntorno = 700;

		tablero = new Rectangle(0, 60, anchoEntorno + 7, altoEntorno);

		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Torre Magica - Grupo Galiano - Nores - Romero - V0.01", anchoEntorno,altoEntorno + 20);
		this.fondo = cargarImagen("fondo.jpg");
		this.imgCorazon = cargarImagen("corazon.png");
		this.tiempo = 60;								//simula el tiempo para que termine el juego
		this.hecLanzados = 0;
		this.puntos = 0;
		this.vidas = 3;
		this.monstruosVivos = 4;
		this.pause = false;
		
		crearPlataformas();
		crearMago();
		crearMonstruos();

		// crea los objetos disparo
		disparos = new ArrayList<Disparo>();

		// Inicia el juego!
		this.entorno.iniciar();
	}

	private void crearPlataformas() {
		plataforma = new Plataforma[9];
		// crea los objetos plataformas
		plataforma[0] = new Plataforma(0, 20 + tablero.y, 150, cargarImagen("platCC.jpg"));
		plataforma[1] = new Plataforma(365, 20 + tablero.y, 150, cargarImagen("platCC.jpg"));
		plataforma[2] = new Plataforma(100, 120 + tablero.y, 300, cargarImagen("platGG.jpg"));
		plataforma[3] = new Plataforma(0, 230 + tablero.y, 200, cargarImagen("platMM.jpg"));
		plataforma[4] = new Plataforma(315, 230 + tablero.y, 200, cargarImagen("platMM.jpg"));
		plataforma[5] = new Plataforma(150, 360 + tablero.y, 200, cargarImagen("platMM.jpg"));
		plataforma[6] = new Plataforma(100, 500 + tablero.y, 300, cargarImagen("platGG.jpg"));
		plataforma[7] = new Plataforma(0, 630 + tablero.y, 190, cargarImagen("platMC.jpg"));
		plataforma[8] = new Plataforma(335, 630 + tablero.y, 190, cargarImagen("platMC.jpg"));
	}

	private void crearMago() {
		// crea el objeto mago
		mago = new Mago(plataforma[2].getX(), plataforma[2].getY(), RUTA_IMAGENES, 0.2);
		PointRectangle.posicionarSobre(mago.rectangulo, plataforma[2].rectangulo);
	}

	private void crearMonstruos() {		
		monstruo = new Monstruo[monstruosVivos];
		// creando los objetos montruos
		Rectangle rectP5 = plataforma[5].rectangulo;				//selecciono las plataformas donde quiero que se ubiquen
		Rectangle rectP6 = plataforma[6].rectangulo;				//los monstruos
		double imgEscala = 0.2;
		monstruo[0] = new Monstruo(rectP5.x + 30, rectP5.y - 30, Math.PI, RUTA_IMAGENES, imgEscala);
		monstruo[1] = new Monstruo(rectP5.x + rectP5.width - 30, rectP5.y - 36, 0.0, RUTA_IMAGENES,imgEscala);
		monstruo[2] = new Monstruo(rectP6.x + 30, rectP6.y - 30, Math.PI, RUTA_IMAGENES, imgEscala);
		monstruo[3] = new Monstruo(rectP6.x + rectP6.width - 30, rectP6.y - 36, 0.0, RUTA_IMAGENES,imgEscala);
	}
	
	// funcion para cargar las imagenes 
	private Image cargarImagen(String nombreImagen) {
		return Herramientas.cargarImagen(RUTA_IMAGENES + nombreImagen);
	}
	
	// verifica si el juego termino
	private boolean juegoTerminado() {
		return tiempo == 0 || vidas == 0 || monstruosVivos == 0;
	}

	/** Durante el juego, método tick() es el método más importante de esta clase.
	 * Aquí se debe actualiza el estado interno del juego para simular el paso del tiempo.*/
	
	public void tick() {
		/** Procesamientos del juego */
		if (!juegoTerminado()) {
			if (!pause) {
				tiempo -= 0.01;
				actualizarObjetos();
				verificarColisiones();
			}
			verificarTeclas();
		}
		dibujarPantalla();
	}

	private void actualizarObjetos() {
		/* PROCESO DEL MAGO */
		mago.avanzar();

		/* PROCESOS DE LOS DISPAROS */
		for (Disparo d : disparos) {
			d.avanzar();
		}

		/* PROCESOS DE LOS MONTRUOS */
		for (int m = 0; m < monstruo.length; m++) {
			if (monstruo[m] != null) {
				if (monstruosVivos == 1) {							//si queda un monstruo vivo aumenta la velocidad
					monstruo[m].velocidad = 2;
				}
				monstruo[m].avanzar();

				if (monstruo[m].congelado && !monstruo[m].muerto) {
					if (monstruo[m].tiempoC <= 0.0) {
						monstruo[m].congelado = false;
						monstruo[m].tiempoC = 1000;
					}
				}
			}
		}
	}

	private void verificarColisiones() {		
		/* PROCESOS DEL MAGO */
		if (!PointRectangle.estaAdentro(mago.rectangulo, tablero)) {
			if (mago.cayendo)
				mago.rectangulo.y = tablero.y;
			else
				mago.mediaVuelta();
		}
		
		// VERIFICO SI EL MAGO ESTA SOBRE ALGUNA PLATAFORMA.
		boolean magoSobreAlgunaPlataforma = false;
		for (int i = 0; i < plataforma.length; i++) {
			if (mago.cayendo) {
				if (PointRectangle.estaSobre(mago.rectangulo, plataforma[i].rectangulo)) {			//se fija si toca alguna plataforma
					magoSobreAlgunaPlataforma = true;
				} 
				else if (PointRectangle.seSolapan(mago.rectangulo, plataforma[i].rectangulo)) {		//si toca alguna plataforma se queda
					PointRectangle.posicionarSobre(mago.rectangulo, plataforma[i].rectangulo);
					magoSobreAlgunaPlataforma = true;
				}				
				if (magoSobreAlgunaPlataforma) {	//si estaba cayendo y toca alguna plataforma, deja de caer y dispara
					mago.dejarDeCaer();
					disparos.add(new Disparo(mago.getX(), mago.getY(), mago.angulo, cargarImagen("hechizo.gif")));
					hecLanzados++;
				}
			} 
			else if (PointRectangle.estaSobre(mago.rectangulo, plataforma[i].rectangulo)) {		//se fija si sigue sobre una plataforma
				magoSobreAlgunaPlataforma = true;
			}
		}
		if (!magoSobreAlgunaPlataforma) {
			mago.comienzaACaer();
		}

		/* PROCESOS DISPARO */
		for (int i = 0; i < disparos.size(); i++) {
			Disparo d = disparos.get(i);
			boolean borrarDisparo = false;
			if (!PointRectangle.estaAdentro(d.rectangulo, tablero)) {
				borrarDisparo = true;
			}
			for (int m = 0; m < monstruo.length && !borrarDisparo; m++) {
				if (monstruo[m] != null && PointRectangle.seSolapan(d.rectangulo, monstruo[m].rectangulo)) {
					borrarDisparo = true;

					if (!monstruo[m].muerto) {
						monstruo[m].congelado = true;
						puntos += 20; 										// Suma puntos al congelar un monstruo.
					}
				}
			}
			if (borrarDisparo) {
				disparos.remove(i);
			}
		}

		/* PROCESOS DE LOS MONTRUOS */
		for (int m = 0; m < monstruo.length; m++) {
			if (monstruo[m] != null) {
				boolean monstruoSobreAlgunaPlataforma = false;
				for (int i = 0; i < plataforma.length; i++) {
					if (monstruo[m].cayendo) {
						if (PointRectangle.estaSobre(monstruo[m].rectangulo, plataforma[i].rectangulo)) { //se fija si toca plataforma
							monstruo[m].dejarDeCaer();
							monstruoSobreAlgunaPlataforma = true;
						}
						else if (PointRectangle.seSolapan(monstruo[m].rectangulo, plataforma[i].rectangulo)) { //si toca plataforma se queda
							monstruo[m].dejarDeCaer();
							PointRectangle.posicionarSobre(monstruo[m].rectangulo, plataforma[i].rectangulo);
							monstruoSobreAlgunaPlataforma = true;
						}
					}
					else if (PointRectangle.estaSobre(monstruo[m].rectangulo, plataforma[i].rectangulo)) { //se fija si sigue sobre plataforma
						monstruoSobreAlgunaPlataforma = true;
					}
				}
				if (!monstruoSobreAlgunaPlataforma) {
					monstruo[m].comienzaACaer();
				}
				if (!monstruo[m].muerto && PointRectangle.seSolapan(monstruo[m].rectangulo, mago.rectangulo)) {
					if (monstruo[m].congelado) {
						monstruo[m].empujadoPor(mago);
						monstruo[m].muerto = true;
						monstruo[m].tiempoC = 0;
					}
					else {
						vidas--;
						puntos -= 10;
						crearMago();
					}
				}
				for (int m2 = 0; m2 < monstruo.length; m2++) {
					if (monstruo[m2] != null) {
						if (m != m2 && monstruo[m].muerto && !monstruo[m2].muerto) {
							if (PointRectangle.seSolapan(monstruo[m].rectangulo, monstruo[m2].rectangulo)) {
								monstruo[m2].empujadoPor(monstruo[m]);
							}
						}
					}
				}
				if (!PointRectangle.estaAdentro(monstruo[m].rectangulo, tablero)) {
					if (monstruo[m].cayendo) {
						if (monstruo[m].muerto) {
							monstruo[m] = null;
							monstruosVivos--;
							puntos += 45;
						}
						else {
							monstruo[m].rectangulo.y = tablero.y;
						}
					}
					else {
						monstruo[m].mediaVuelta();
					}
				}
			}
		}
	}

	private void verificarTeclas() {
		if (!pause) {			
			if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				mago.caminarIzq = false;
				mago.caminarDer = true;
			} 
			else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				mago.caminarDer = false;
				mago.caminarIzq = true;
			}
			if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
				disparoEspecial();
			}
		}
		if (entorno.sePresiono(entorno.TECLA_ENTER)) {
			pause = !pause;
		}
	}

	private void disparoEspecial() {
		if (hecLanzados >= 8) {
			for (int i = 0; i < 8; i++) {
				double angulo = Math.PI * i / 4;
				disparos.add(new Disparo(mago.getX(), mago.getY(), angulo, cargarImagen("hechizo.gif")));
			}
			this.hecLanzados = 0;
		}
	}

	// -------- DIBUJA TODO EL JUEGO
	private void dibujarPantalla() {
		entorno.dibujarImagen(fondo, tablero.getCenterX(), tablero.getCenterY(), 0);

		DibujarPanel();

		if (!juegoTerminado()) {
			/* DIBUJO PLATAFORMAS */
			for (Plataforma p : plataforma) {
				p.dibujar(entorno);
			}
			/* DIBUJO AL MAGO */
			mago.dibujar(entorno);

			/* DIBUJO DISPAROS */
			for (Disparo d : disparos) {
				d.dibujar(entorno);
			}
			/* DIBUJO LOS MONSTRUOS VIVOS */
			for (int m = 0; m < monstruo.length; m++) {
				if (monstruo[m] != null) {
					monstruo[m].dibujar(entorno);
				}
			}
			/* PARA PAUSAR EL JUEGO PRESIONANDO ENTER*/
			if (pause) {
				entorno.cambiarFont(Font.SERIF, 150, Color.RED);
				entorno.escribirTexto("PAUSE", 20, 330);
			}
			
		} 
		// FIN DEL CICLO DEL JUEGO
		else {
			String resultado;
			/* SI MATO TODOS LOS MONSTRUOS SALE EL CARTEL GANASTE */
			if (monstruosVivos == 0) {
				resultado = "GANASTE";
			}
			/* SI SE QUEDO SIN VIDAS SALE EL CARTEL PERDISTE */
			else if (vidas == 0) {
				resultado = "PERDISTE";
			}
			/* SI SE QUEDO SIN TIEMPO SALE EL CARTEL FIN DEL JUEGO */
			else {
				tiempo = 0;														//para que deje de correr
				resultado = "Game Over";
			}
			entorno.cambiarFont(Font.SANS_SERIF, 90, Color.RED);
			entorno.escribirTexto(resultado, 35, 340);
			entorno.cambiarFont(Font.SANS_SERIF, 50, Color.RED);
			entorno.escribirTexto( puntos + " puntos", 130, 400);
		}
	}

	private void DibujarPanel() {
		entorno.dibujarRectangulo(tablero.getCenterX(), 30, tablero.width + 30, 60, 0, Color.LIGHT_GRAY);
		entorno.dibujarRectangulo(tablero.getCenterX() + 2 , 30, tablero.width - 5, 52, 0, Color.BLACK);
		
		entorno.cambiarFont(Font.DIALOG, 20, Color.WHITE);
		entorno.escribirTexto("Tiempo:" + (int) tiempo, 400, 25);
		entorno.escribirTexto("Vidas:", 20, 25);
		for (int i = 0; i < vidas; i++) {
			entorno.dibujarImagen(imgCorazon, 90 + i * 25, 20, 0, 0.03);  //uso la escala para achicar la imagen y no perder la resolucion
		}
		entorno.escribirTexto("DisparoEspecial:", 20, 50);

		entorno.dibujarRectangulo(210, 43, 80, 20, 0, Color.WHITE);
		entorno.dibujarRectangulo(210, 43, 78, 18, 0, Color.BLACK);

		int nivelCarga = hecLanzados;
		if (nivelCarga > 8)
			nivelCarga = 8;
		for (int i = 0; i < nivelCarga; i++) {
			Color color;
			if (nivelCarga == 8) {
				color = Color.GREEN;
			} 
			else if (i < 4) {
				color = Color.RED;
			} 
			else if (i < 7) {
				color = Color.YELLOW;
			} 
			else {
				color = Color.GREEN;
			}
			entorno.dibujarRectangulo(175 + i * 10, 43, 8, 18, 0, color);
		}
		if (!juegoTerminado()) {
			entorno.cambiarFont(Font.SANS_SERIF, 20, Color.GRAY);
			entorno.escribirTexto("Puntaje:" + puntos, 200, 27);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}