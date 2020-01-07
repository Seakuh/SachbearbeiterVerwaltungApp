package com.example.iu4;


public class SachbearbeiterK {

    public SachbearbeiterEK eingabeKontrolle(String bN, String pw) {
        SachbearbeiterEK falscheEingabe = new SachbearbeiterEK("Falsche Eingabe", "Falsche Eingabe", "Falsche Eingabe");


        String[] allNames = SachbearbeiterEK.gibAlleNamen();
        for (int i = 0; i < SachbearbeiterEK.gibAnzahl(); i++) {
            if (bN.equals(allNames[i])) {
                SachbearbeiterEK kopie = SachbearbeiterEK.gib(allNames[i]);
                if (kopie.getPasswort().equals(pw)) {
                    return kopie;
                } else {
                    System.out.println("Falsches Passwort");
                }
            }

        }

        System.out.println("Zu viele fehlversuche \nProgramm beendet...");
        return falscheEingabe;
    }

    public SachbearbeiterEK gibSachbearbeiter(String name) {
        return SachbearbeiterEK.getSachbearbeiter(name);
    }

    public void setStatusFortbildung(String a, String berechtigung) {

    }

    public static void setBerechtigung(String name) {

    }

    public static void fortbildungzuordnen(String sachbearbeiter, String fortbildung, String status) {


    }

}
