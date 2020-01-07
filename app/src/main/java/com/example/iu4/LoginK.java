package com.example.iu4;

public class LoginK {
	public static String kontrolleEingabe(String benutzername, String passwort) {
		String[] allNames = SachbearbeiterEK.gibAlleNamen();
		for (int i = 0; i < SachbearbeiterEK.gibAnzahl(); i++) {
			if (benutzername.equals(allNames[i])) {
				SachbearbeiterEK kopie = SachbearbeiterEK.gib(allNames[i]);
				System.out.println(kopie.getPasswort());
				if (kopie.getPasswort().equals(passwort)) {
					System.out.println("Eingabe Korrekt");
					if(kopie.getBerechtigung().equals("admin")) {
						return "admin";
					}
					if(kopie.getBerechtigung().equals("normal")){
						return "normal";
					}
				} else {
					System.out.println("Falsches Passwort");
				}
			}
		}
		return "false";
	}

}
