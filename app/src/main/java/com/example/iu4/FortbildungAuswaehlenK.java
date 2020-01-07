package com.example.iu4;



public class FortbildungAuswaehlenK {
	
	String[] fortbildungen;
	WrappergibFotbildungen wrapper = new WrappergibFotbildungen();
	
	public FortbildungAuswaehlenK() {
		fortbildungen = wrapper.gibNamenWrapper();
	}

	String[] gibNamen() {
		return fortbildungen;
	}

	String wrappergibFortbildungen(Fortbildung diese) {
		return diese.getTitel();
	}

	public class WrappergibFotbildungen {

		String[] namen;
		Fortbildung neeu = new Fortbildung();

		WrappergibFotbildungen() {
			namen = neeu.gibAlleFortbildungen();

		}

		public String[] gibNamenWrapper() {
			return namen;
		}

	}

}
