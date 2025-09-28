package clase;

import java.awt.*;

public class PointRectangle {
	
	static double distancia(Point p1, Point p2) {
		double catA = p2.x - p1.x;
		double catB = p2.y - p1.y;
		return Math.sqrt(catA * catA + catB * catB);
	}

	public static Point centro(Rectangle r) {
		Point res = new Point(r.x + r.width / 2, r.y + r.height / 2);
		return res;
	}

	public static boolean estaAdentro(Point p, Rectangle r) {
		return (p.x >= r.x && p.x <= r.x + r.width) && (p.y >= r.y && p.y <= r.y + r.height);
	}

	/**
	 * Verifica si el rectangulo r1 esta completamente dentro del rectangolo r2.
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean estaAdentro(Rectangle r1, Rectangle r2) {
		return (r1.x >= r2.x && r1.x+r1.width <= r2.x + r2.width) && (r1.y >= r2.y && r1.y+r1.height <= r2.y + r2.height);
	}

	public static void agranda(Rectangle r, int ancho, int alto) {
		r.x = r.x + ancho;
		r.y = r.y + alto;
	}

	public static boolean seSolapan(Rectangle r1, Rectangle r2) {
		if (r1.x + r1.width < r2.x) {
			return false;
		}
		if (r1.x > r2.x + r2.width) {
			return false;
		}
		if (r1.y + r1.height < r2.y) {
			return false;
		}
		if (r1.y > r2.y + r2.height) {
			return false;
		}
		return true;
	}

	/**
	 * Verifica si el rectangulo r1 esta posicionado justo sobre el rectangulo r2 sin solaparse. pero sin dejar espacio entre ambos.
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean estaSobre(Rectangle r1, Rectangle r2) {
		if (r1.x + r1.width < r2.x) {
			return false;
		}
		if (r1.x > r2.x + r2.width) {
			return false;
		}

		if (r1.y + r1.height != r2.y - 1) {
			return false;
		}

		return true;
	}

	public static void posicionarSobre(Rectangle r1, Rectangle r2) {
		r1.y = r2.y - 1 - r1.height;
	}

	public static Rectangle cajaContenedora(Rectangle r1, Rectangle r2) {
		int x = Math.min(r1.x, r2.x);
		int y = Math.min(r1.y, r2.y);
		int ancho = Math.max(r1.x + r1.width, r2.x + r2.width) - x;
		int alto = Math.max(r1.y + r1.height, r2.y + r2.height) - y;
		// Rectangle res=new Rectangle(x, y, ancho, alto);
		// return res;
		return new Rectangle(x, y, ancho, alto);

	}

	public static void main(String[] args) {
		Point p = new Point(4, 3);
		Point p1 = new Point(8, 6);
		System.out.println(distancia(p, p1));
		Rectangle r = new Rectangle(2, 10, 20, 20);
		System.out.println(centro(r));
		System.out.println(estaAdentro(p, r));
		System.out.println(r);
		agranda(r, 10, 50);
		System.out.println(r);
		Rectangle r1 = new Rectangle(14, 61, 4, 10);
		System.out.println(seSolapan(r, r1));

	}

}