package com.example.iu4;


import java.util.regex.Pattern;


public class AdminSachbearbeiterErzeugenK {


    public boolean vergeben(String neu) {
        String[] all = SachbearbeiterEK.gibAlleNamen();
        for (int i = 0; i < all.length; i++) {
            if (neu.equals(all[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean eingabeBenutzername(String eing) {
        boolean b = Pattern.matches("[a-zA-Z_ß]+", eing);
        if (b) {
            return true;
        } else {
            return false;
        }

    }

    public void trageNeuenNutzerein(String benutzername, String passwort, String berechtigung) {
        System.out.println(benutzername + passwort + berechtigung);
        System.out.println(vergeben(benutzername));
        System.out.println(eingabeBenutzername(benutzername));
        if ((!vergeben(benutzername)) && (eingabeBenutzername(benutzername))) {
            SachbearbeiterEK neu = new SachbearbeiterEK(benutzername, passwort, berechtigung);
            neu.add();

        } else {

        }
    }
}
