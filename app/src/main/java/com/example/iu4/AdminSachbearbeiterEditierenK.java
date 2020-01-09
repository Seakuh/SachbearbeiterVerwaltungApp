package com.example.iu4;

import java.util.regex.Pattern;

public class AdminSachbearbeiterEditierenK extends SachbearbeiterS {

    public boolean kontrolliereEingabe(String bn, String pw, String berechtigung, String sachbearbeiter) {

        System.out.println("In der Kontrolle");

        System.out.println(bn);
        System.out.println(pw);
        System.out.println(berechtigung);
        System.out.println(sachbearbeiter);


        SachbearbeiterEK bearbeiten = SachbearbeiterEK.gib(sachbearbeiter);
        bearbeiten.setPasswort(pw);
        if (eingabeBenutzername(bn)) {
            bearbeiten.setBenutzername(bn);
            bearbeiten.setBerechtigung(berechtigung);

            return true;


        } else {

            return false;

        }

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

