package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Mago {
	Rectangle rectangulo;
	int ancho, alto;
	double  angulo;
	Image mago;
	int velocidad;
	boolean cayendo;
	boolean caminarDer, caminarIzq;
	Image imgDerecha,imgIzquierda;
	double imgEscala;

	Mago(int x, int y, String rutaImagenes,double imgEscala) {
		this.ancho = 35; 
		this.alto = 50;
		this.rectangulo= new Rectangle(x , y , ancho , alto);
		this.velocidad = 2;
		this.cayendo = false;
		this.angulo = 0;
		this.caminarDer = false;
		this.caminarIzq = false;
		//this.imgDerecha = Herramientas.cargarImagen(rutaImagenes+"mago-derecha.gif");
		//this.imgIzquierda = Herramientas.cargarImagen(rutaImagenes+"mago-izquierda.gif");
		this.imgDerecha = Herramientas.cargarImagen(rutaImagenes+"hechicera-derecha.gif");
		this.imgIzquierda = Herramientas.cargarImagen(rutaImagenes+"hechicera-izquierda.gif");
		this.imgEscala = imgEscala;
	}

	void dibujar(Entorno e) {
		//e.dibujarRectangulo(getX(), getY(), rectangulo.width, rectangulo.height, angulo, Color.cyan);
		//e.dibujarTriangulo(getX(), getY(), rectangulo.width, rectangulo.height, angulo, Color.ORANGE);
		if (caminarDer) {
			e.dibujarImagen(imgDerecha, getX(), getY(), 0, imgEscala);
		} 
		else {
			e.dibujarImagen(imgIzquierda, getX(), getY(), 0, imgEscala);
		}		
	}

	void avanzar() {
		if (cayendo) {
			if (caminarDer) {
				angulo = 0.0;
			}
			if (caminarIzq) {
				angulo = Math.PI;
			}			
			rectangulo.y += velocidad;

		}
		else {
			if (caminarDer) {
				rectangulo.x += velocidad;
				angulo = 0.0;
			} else if (caminarIzq) {
				rectangulo.x -= velocidad;
				angulo = Math.PI;
			}
		}
	}
	
	void mediaVuelta() {
		if (caminarDer) {
			caminarDer = false;
			caminarIzq = true;
		}
		else  {
			caminarDer = true;
			caminarIzq = false;
		}
	}
	
	public void dejarDeCaer() {
		cayendo = false;
	}
	
	public void comienzaACaer() {
		cayendo = true;
	}

	int getX() {
		return (int)rectangulo.getCenterX();
	}

	int getY() {
		return (int)rectangulo.getCenterY();
	}
}