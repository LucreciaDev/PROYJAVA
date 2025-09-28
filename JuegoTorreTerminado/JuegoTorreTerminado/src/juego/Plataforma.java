package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;

public class Plataforma {
	Rectangle rectangulo;
	private Image imagenPlataforma;

	Plataforma(int x, int y, int ancho, Image imagen) {
		this.rectangulo = new Rectangle(x, y, ancho, 20);
		this.imagenPlataforma = imagen;
	}

	void dibujar(Entorno e) {
 		//e.dibujarRectangulo(getX(), getY(), rectangulo.width, rectangulo.height, 0, Color.CYAN);
		e.dibujarImagen(imagenPlataforma, getX(), getY(), 0);
	}
	
	int getX() {
		return (int)rectangulo.getCenterX();
	}

	int getY() {
		return (int)rectangulo.getCenterY();
	}
}