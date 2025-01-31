package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmer;
	private int antall;
	
	public Filmarkiv(int kapasitet) {
		filmer = new Film[kapasitet];
		antall = 0;
	}
	
	private void utvid() {
		Film[] nyTabell = new Film[filmer.length * 2];
		for (int i = 0; i < antall; i++) {
			nyTabell[i] = filmer[i];
		}
		filmer = nyTabell;
	}
	
	@Override
	
	
}
