package com.example.iu4;


import java.util.regex.Pattern;



public class SachbearbeiterEditierenK {


	public void kontrolliereEingabe(String bn, String pw, String berechtigung, String sachbearbeiter) {

		SachbearbeiterEK bearbeiten = SachbearbeiterEK.gib(sachbearbeiter);
		bearbeiten.setPasswort(pw);


	}

	public boolean eingabeBenutzername(String eing) {
		boolean b = Pattern.matches("[a-zA-Z_ß]+", eing);
		if (b) {
			return true;
		} else {
			return false;
		}

	}

}
