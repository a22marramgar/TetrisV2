package taulell;

import pieza.*;

public class Taulell {
	
	private TipoPieza[][] _matriu;
	private int _amplada;
	
	public Taulell(int alcada, int amplada) {
		this._matriu = new TipoPieza[alcada][amplada];
		this._amplada = amplada;
		for(int i = 0; i<this._matriu.length; i++) {
			for(int j = 0; j<this._matriu[i].length;j++) {
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
	
	public boolean FerCaureLaPieza(Pieza p) {
		p.getColumna();
		return false;
	}
}
