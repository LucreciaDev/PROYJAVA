package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Monstruo {
	Rectangle rectangulo;
	int ancho, alto;
	double angulo, anguloAnt;
	int velocidad;
	double velGiro;
	boolean cayendo, congelado, muerto;
	double tiempoC;
	Image imgDerecha, imgIzquierda, imgCongelado, imgCongeladoDerecha, imgCongeladoIzquierda;
	double imgEscala;

	Monstruo(int x, int y, double angulo, String rutaImagenes, double imgEscala) {
		this.ancho = 33;
		this.alto = 50;
		rectangulo = new Rectangle(x, y, ancho, alto);
		this.velocidad = 1;
		this.cayendo = false;
		this.congelado = false;
		this.angulo = angulo;
		this.anguloAnt = angulo;
		this.velGiro = 0.2;
		this.muerto = false;
		this.tiempoC = 500;		
		this.imgEscala = imgEscala;
		this.imgDerecha = Herramientas.cargarImagen(rutaImagenes+"monstruo-derecha.gif");
		this.imgIzquierda = Herramientas.cargarImagen(rutaImagenes+"monstruo-izquierda.gif");
		this.imgCongelado = Herramientas.cargarImagen(rutaImagenes+"monstruo-congelado.png");
		this.imgCongeladoDerecha = Herramientas.cargarImagen(rutaImagenes+"monstruo-congelado-derecha.gif");
		this.imgCongeladoIzquierda = Herramientas.cargarImagen(rutaImagenes+"monstruo-congelado-izquierda.gif");		
	}

	void dibujar(Entorno e) {
		//e.dibujarTriangulo(getX(), getY(), rectangulo.width, rectangulo.height, anguloAnt, Color.GREEN);
		if (congelado && !muerto) {
			e.dibujarImagen(imgCongelado, getX(), getY(), angulo, imgEscala);
		} 
		else if(muerto) {
			if (angulo == 0) {
				e.dibujarImagen(imgCongeladoDerecha, getX(), getY(), 0, imgEscala);
			} 
			else {
				e.dibujarImagen(imgCongeladoIzquierda, getX(), getY(), 0, imgEscala);
			}
		} 
		else {
			if (angulo == 0) {
				e.dibujarImagen(imgDerecha, getX(), getY(), 0, imgEscala);
			} 
			else {
				e.dibujarImagen(imgIzquierda, getX(), getY(), 0, imgEscala);
			}
		}
	}

	void avanzar() {
		if (cayendo) {
			rectangulo.y += velocidad;
		} 
		else {
			if (!congelado) {
				if (angulo == 0.0) {
					rectangulo.x += velocidad;
				}
				if (angulo == Math.PI) {
					rectangulo.x -= velocidad;
				}
			} 
			else if (muerto) {
				if (angulo == 0.0) {
					rectangulo.x += (velocidad + 1);
				}
				if (angulo == Math.PI) {
					rectangulo.x -= (velocidad + 1);
				}
				anguloAnt += velGiro;									//para el efecto del triangulo
				anguloAnt %= 2 * Math.PI;								//que gira en la imagen no se usa
			}
		}
		if (congelado && !muerto)
			this.tiempoC--;
	}

	void mediaVuelta() {
		if (angulo == 0) {
			angulo = Math.PI;
		} 
		else {
			angulo = 0;
		}
		anguloAnt = angulo;
	}

	public void empujadoPor(Mago mago) {
		angulo = mago.angulo;
	}

	public void empujadoPor(Monstruo monstruo) {
		if (monstruo.muerto) {
			congelado = true;
			muerto = true;
			angulo = monstruo.angulo;
		}
	}
	
	public void dejarDeCaer() {
		cayendo = false;
	}
	
	public void comienzaACaer() {
		cayendo = true;
	}

	int getX() {
		return (int) rectangulo.getCenterX();
	}

	int getY() {
		return (int) rectangulo.getCenterY();
	}
}