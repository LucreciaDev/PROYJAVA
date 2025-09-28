package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Disparo {
	Rectangle rectangulo;
	int velocidad;
	double angulo;
	Image hechizo;

	Disparo(int x, int y, double angulo, Image imagen) {
		this.rectangulo = new Rectangle(x,y,10,10);
		this.velocidad = 3;
		this.angulo = angulo;
		this.hechizo = imagen;
	}

	void dibujar(Entorno e) {
		//e.dibujarTriangulo(rectangulo.getCenterX(), rectangulo.getCenterY(), rectangulo.width, rectangulo.height, angulo, Color.WHITE);
		e.dibujarImagen(hechizo,rectangulo.getCenterX(), rectangulo.getCenterY(), angulo);
	}

	void avanzar() {
		double desplazamientoX = Math.cos(angulo) * velocidad;
		double desplazamientoY = Math.sin(angulo) * velocidad;
		rectangulo.translate( (int) desplazamientoX , (int) desplazamientoY );
	}
}