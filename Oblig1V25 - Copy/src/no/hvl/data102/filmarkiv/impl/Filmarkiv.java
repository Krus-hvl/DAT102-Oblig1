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
	public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvid();
        }
        filmer[antall++] = nyFilm;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmNr() == nr) {
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmNr() == filmnr) {
                filmer[i] = filmer[antall - 1];
                filmer[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[teller++] = filmer[i];
            }
        }
        return trimTab(treff, teller);
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        for (int i = 0; i < n; i++) {
            nytab[i] = tab[i];
        }
        return nytab;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
