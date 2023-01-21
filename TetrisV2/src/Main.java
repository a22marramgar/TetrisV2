import pieza.*;

public class Main {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void MostrarPieza(Pieza p, int amplada) {
		for (int i = 0; i < p.getPosicion().length; i++) {
			for (int j = 0; j < amplada; j++) {
				if (j >= p.getColumna() && j < p.getColumna() + 4 && p.getCasilla(i, j - p.getColumna())) {
					switch (p.getTipo()) {
					case piezaI:
						System.out.print(ANSI_CYAN + "■");
						break;
					case piezaO:
						System.out.print(ANSI_YELLOW + "■");
						break;
					case piezaS:
						System.out.print(ANSI_GREEN + "■");
						break;
					case piezaL:
						System.out.print(ANSI_BLUE + "■");
						break;
					case piezaJ:
						System.out.print(ANSI_WHITE + "■");
						break;
					case piezaZ:
						System.out.print(ANSI_RED + "■");
						break;
					case piezaT:
						System.out.print(ANSI_PURPLE + "■");
						break;
					}

				} else {
					System.out.print("□");
				}
				System.out.print(ANSI_RESET);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Pieza p = new Pieza(TipoPieza.piezaI);
		int amplada = 30;
		for (int i = 0; i < 40; i++) {
			p.moverDer(amplada);
		}
		MostrarPieza(p, amplada);
		p.rotar(amplada);
		MostrarPieza(p, amplada);
		p.rotar(amplada);
		MostrarPieza(p, amplada);
		p.rotar(amplada);
		MostrarPieza(p, amplada);

	}

}
