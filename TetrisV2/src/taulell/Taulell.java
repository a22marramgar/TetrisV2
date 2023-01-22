package taulell;

import pieza.*;

public class Taulell {

	private TipoPieza[][] _matriu;
	private int _amplada;

	public Taulell(int alcada, int amplada) {
		this._matriu = new TipoPieza[alcada][amplada];
		this._amplada = amplada;
		for (int i = 0; i < this._matriu.length; i++) {
			for (int j = 0; j < this._matriu[i].length; j++) {
				this._matriu[i][j] = TipoPieza.piezaNula;
			}
		}
	}

	public TipoPieza[][] getTaulell() {
		return this._matriu;
	}

	public int getAmplada() {
		return this._amplada;
	}

	private int BuscarPosicio(Pieza p) {
		boolean[][] posicionPieza = p.getPosicion();
		int altura = -1;
		boolean ocupado = false;
		for (int i = p.getAlto()-1; i < _matriu.length && !ocupado; i++) {
			for (int j = 0; j < posicionPieza.length; j++) {
				for (int k = 0; k < posicionPieza.length; k++) {
					if (posicionPieza[j][k] && _matriu[j + i - 3][p.getColumna() + k] != TipoPieza.piezaNula) {
						altura = i - 1;
						ocupado = true;
					}
				}
			}
			if (altura==-1&&i == _matriu.length - 1) {
				altura = i;
			}
		}
		return altura;

	}

	public boolean FerCaureLaPieza(Pieza p) {
		boolean[][] posicionPieza = p.getPosicion();
		boolean ocupado = false;

		int altura = BuscarPosicio(p);
		if (altura < p.getAlto()-1) {
			ocupado = true;
		} else {
			for (int j = posicionPieza.length - 1; j >= 0; j--) {
				for (int k = 0; k < p.getAncho(); k++) {
					if (posicionPieza[j][k]) {
						_matriu[altura][p.getColumna() + k] = p.getTipo();
					}
				}
				altura--;
			}
		}
		return ocupado;
	}
}
