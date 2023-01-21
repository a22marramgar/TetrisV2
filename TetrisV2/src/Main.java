import menu.*;
import pieza.*;
import taulell.Taulell;

public class Main {

	public static void main(String[] args) {
		Taulell t = Menu.DefinirTablero();
		Pieza p = Menu.ControlarPieza(t);
		Menu.MostrarTaulell(t);
	}

}
