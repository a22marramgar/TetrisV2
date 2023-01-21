package menu;

import java.util.Scanner;

import pieza.Pieza;
import pieza.TipoPieza;

public class Menu {
	
	public static final Scanner scan = new Scanner(System.in);
	
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

	public static Pieza ControlarPieza(int amplada) {
		int dau = (int) (Math.random() * 7 + 1);
		Pieza p = null;
		switch (dau) {
			case 1:
				p = new Pieza(TipoPieza.piezaI);
				break;
			case 2:
				p = new Pieza(TipoPieza.piezaO);
				break;
			case 3:
				p = new Pieza(TipoPieza.piezaS);
				break;
			case 4:
				p = new Pieza(TipoPieza.piezaJ);
				break;
			case 5:
				p = new Pieza(TipoPieza.piezaL);
				break;
			case 6:
				p = new Pieza(TipoPieza.piezaZ);
				break;
			case 7:
				p = new Pieza(TipoPieza.piezaT);
				break;
		}
		boolean salir = false;
		do {
			clearScreen();
			
			MostrarPieza(p,amplada);
			System.out.println("a: [←], d: [→], r: rotar s: llencar peca");
			switch (scan.nextLine().toLowerCase()) {
			case "a":
				p.moverIzq();

				break;
			case "d":
				p.moverDer(amplada);
				break;
			case "r":
				p.rotar(amplada);
				break;
			case "s":
				salir = true;
				break;
			default:
				break;
			}
		}while(!salir);
		return p;
	}
	
	public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }
}
