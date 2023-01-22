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
		for (int i = p.getAlto(); i < _matriu.length && !ocupado; i++) {
			for (int j = 0; j < posicionPieza.length; j++) {
				for (int k = 0; k < posicionPieza.length; k++) {
					if(i==_matriu.length-1) {
						altura = i;
					}else if(posicionPieza[j][k] && _matriu[j + i-3][p.getColumna() + k] != TipoPieza.piezaNula) {
						altura = i-1;
						ocupado = true;
					}
					/*if (i==_matriu.length-1||posicionPieza[j][k] && _matriu[j + i-4][p.getColumna() + k] != TipoPieza.piezaNula) {
						ocupado = true;
					}*/
				}
			}
			/*
			 * ocupado = false; boolean siguiente = false; for (int j = posicionPieza.length
			 * - p.getAlto(); j < posicionPieza.length && !siguiente; j++) { for (int k = 0;
			 * k < p.getAncho() && !siguiente; k++) { if (posicionPieza[j][k] &&
			 * _matriu[i][p.getColumna() + k] != TipoPieza.piezaNula) { siguiente = true; }
			 * } } if (!ocupado) { altura = i; ocupado = true; }
			 */
			/*if (ocupado) {
				altura = i;
			}*/
		}
		return altura;

	}

	public boolean FerCaureLaPieza(Pieza p) {
		boolean[][] posicionPieza = p.getPosicion();
		boolean ocupado = false;

		int altura = BuscarPosicio(p);
		if (altura == -1) {
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
