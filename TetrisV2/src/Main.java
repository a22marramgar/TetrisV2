import menu.*;
import pieza.*;
import taulell.Taulell;

public class Main {

	public static void main(String[] args) {
		Taulell t = Menu.DefinirTaulell();
		boolean finalPartida = false;
		while (!finalPartida) {
			Pieza p = Menu.ControlarPieza(t);
			finalPartida = t.FerCaureLaPieza(p);
		}
		System.out.println("Fin de la partida");
	}

}
