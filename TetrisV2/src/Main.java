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
			t.ComprobarFilas();
		}
		System.out.println("Fi de la partida");
		System.out.println("Puntuacio: "+t.getPuntuacion());
	}

}
