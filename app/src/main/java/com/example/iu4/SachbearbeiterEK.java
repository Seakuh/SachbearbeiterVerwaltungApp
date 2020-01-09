package com.example.iu4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class SachbearbeiterEK {
    private String passwort;
    private String berechtigung;
    private String benutzerName;
    private static HashSet<SachbearbeiterEK> sachBearbeiter = new HashSet<SachbearbeiterEK>();

    public Map<Fortbildung, String> getFortbildungen() {
        return fortbildungen;
    }

    private Map<Fortbildung, String> fortbildungen = new HashMap<Fortbildung, String>();

    SachbearbeiterEK(String benutzername, String Passwort, String Berechtigung) {
        benutzerName = benutzername;
        passwort = Passwort;
        berechtigung = Berechtigung;
    }

    SachbearbeiterEK(String benutzername, String Passwort) {
        benutzerName = benutzername;
        passwort = Passwort;
        berechtigung = "normal";
    }

    SachbearbeiterEK() {
    }

    static {
        // Admin + Benutzer erzeugen
        SachbearbeiterEK eins = new SachbearbeiterEK("1", "1", "admin");
        SachbearbeiterEK admin = new SachbearbeiterEK("admin", "1234", "admin");
        SachbearbeiterEK Hans = new SachbearbeiterEK("Hans", "1234", "normal");
        SachbearbeiterEK Gustav = new SachbearbeiterEK("Henna", "1234", "normal");
        SachbearbeiterEK Günter = new SachbearbeiterEK("Guenti_g", "1234", "normal");
        SachbearbeiterEK Elfride = new SachbearbeiterEK("Elfißees", "1234", "normal");
        SachbearbeiterEK Petra = new SachbearbeiterEK("Peti", "1234", "normal");

        admin.add();
        Hans.add();
        Gustav.add();
        Günter.add();
        Elfride.add();
        Petra.add();
    }

    public static SachbearbeiterEK getSachbearbeiter(String Bentzername) {
        SachbearbeiterEK result = new SachbearbeiterEK();
        for (SachbearbeiterEK it : sachBearbeiter) {
            if (it.benutzerName.equals(Bentzername)) {
                result.kopiereAttribute(it);
            }
        }
        return result;
    }

    public void add() {
        sachBearbeiter.add(this);
    }

    public void delete() {
        sachBearbeiter.remove(this);
    }

    public static String[] gibAlleNamen() {
        String[] allNames = new String[sachBearbeiter.size()];
        int it = 0;
        for (SachbearbeiterEK all : sachBearbeiter) {
            allNames[it] = all.getBenutzerName();
            it++;
        }
        return allNames;
    }

    public void kopiereAttribute(SachbearbeiterEK attkopie) {
        this.benutzerName = attkopie.benutzerName;
        this.passwort = attkopie.passwort;
        this.berechtigung = attkopie.berechtigung;
    }

    public SachbearbeiterEK gibKopie(String vergl) {
        SachbearbeiterEK sachbearbeiterKopie = new SachbearbeiterEK();
        for (SachbearbeiterEK sachB : sachBearbeiter) {
            if (vergl.equals(sachB.benutzerName)) {
                sachbearbeiterKopie.kopiereAttribute(sachB);
                // System.out.println(sachbearbeiterKopie.benutzerName + " Benutzername");
                // System.out.println(sachbearbeiterKopie.passwort + " Passwort");
                // System.out.println(sachbearbeiterKopie.berechtigung + " Berechtigung");

            }
        }
        return sachbearbeiterKopie;
    }

    public static SachbearbeiterEK gib(String inName) {
        for (int i = 0; i < 3; i++) {
            for (SachbearbeiterEK sachB : sachBearbeiter) {
                if (inName.equals(sachB.benutzerName)) {
                    return sachB;
                }
            }
            System.out.println("Kein Sachbearbeiter namens: " + inName);
            int v = 3 - i;
            System.out.println("Anzahl Versuche: " + v);
            Scanner neu = new Scanner(System.in);
            String innName = neu.nextLine();
            inName = innName;
        }
        return null;
    }

    public String getPasswort() {
        return this.passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setBenutzername(String name) {
        this.benutzerName = name;
        System.out.println("Benutzername von " + this.benutzerName + "geöndert");
    }

    public void setBerechtigung(String name) {
        this.berechtigung = name;
    }

    public String getBenutzerName() {
        return this.benutzerName;
    }

    public String getBerechtigung() {
        return this.berechtigung;
    }

    public static int gibAnzahl() {
        return sachBearbeiter.size();
    }

    public static void druckeAlleNamen() {
        String[] allNames = SachbearbeiterEK.gibAlleNamen();
        System.out.println("----Alktuelle Sacharbeiter----");
        for (int i = 0; i < allNames.length; i++) {
            System.out.println(allNames[i] + "\t\t" + (SachbearbeiterEK.gib(allNames[i]).berechtigung));
        }
        System.out.println("------------------------------");

    }

    public void getAbsolvierteFortbildungen() {
        for (Fortbildung a : fortbildungen.keySet()) {
            if (fortbildungen.get(a).equals("absolviert"))
                System.out.println(a.getTitel());
        }
    }

    public void bucheFortbildung(Fortbildung zuweisung) {
        fortbildungen.put(zuweisung, "belegt");
    }

    public String getZuordnung(String name) {
        for (Fortbildung a : fortbildungen.keySet()) {
            if (a.getTitel().equals(name)) {
                return fortbildungen.get(a);
            }
        }
        return "keine Zuordnung";
    }

    public static void druckeAlleFortbildungenVonAktuellemSachbearbeiter(SachbearbeiterEK pruf) {
        System.out.println("----Fortbildungen----");
        for (Fortbildung a : pruf.fortbildungen.keySet()) {
            System.out.println(a.getTitel() + "\t" + SachbearbeiterEK.getStatus(pruf, a));
        }
        System.out.println("---------------------");
    }

    public static boolean fortbildungBelegt(SachbearbeiterEK pruf, Fortbildung fort) {
        if (pruf.fortbildungen.containsKey(fort)) {
            return true;
        } else {
            return false;
        }

    }

    public void setStatus(SachbearbeiterEK name, Fortbildung fort, String status) {
        for (Fortbildung a : name.fortbildungen.keySet()) {
            if (a.getTitel().equals(fort.getTitel())) {
                name.fortbildungen.replace(a, status);
            }
        }
    }

    public static void druckeFortbildungenStatus(SachbearbeiterEK sachB) {
        System.out.println("-------------" + sachB.getBenutzerName() + "-------------");
        for (Fortbildung a : sachB.fortbildungen.keySet()) {
            System.out.println(a.getTitel() + "  " + sachB.fortbildungen.get(a));
        }
        System.out.println("-------------------------------");

    }

    public static boolean pruefeVorraussetzung(SachbearbeiterEK a, Fortbildung b) {
        String vor[] = b.getVorraussetzung(b);
        if (vor[0] == "") {
            return true;
        }

        if ((vor[1] == "") && (getStatus(a, Fortbildung.gib(vor[0])).equals("Bestanden"))) {
            return true;
        } else if (getStatus(a, Fortbildung.gib(vor[0])).equals("Bestanden")
                && getStatus(a, Fortbildung.gib(vor[1])).equals("Bestanden")) {
            return true;
        }
        return false;

    }

    public static String getStatus(SachbearbeiterEK sachB, Fortbildung a) {

        for (Fortbildung it : sachB.fortbildungen.keySet()) {
            if (a.getTitel().equals(it.getTitel())) {
                return sachB.fortbildungen.get(a);
            }
        }
        return "Kein Status";

    }

//	@SuppressWarnings("null")
//	public String[] getFortbildungen(String sachB) {
//		String[] erg = null;
//		SachbearbeiterEK dieser = SachbearbeiterEK.gib(sachB);
//		int i = 0;
//
//		for (Fortbildung a : dieser.fortbildungen.keySet()) {
//			System.out.println(a);
//			erg[i] = a.getTitel();
//			i++;
//		}
//
//		if (erg[0] == null) {
//			erg[0] = "Keine Belegung";
//		}
//
//		return erg;
//	}

    public static boolean hatFortbuldungen(SachbearbeiterEK test) {
        if (test.fortbildungen.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void loescheFortbildungVersehentlich(SachbearbeiterEK name, Fortbildung fort) {

        name.fortbildungen.remove(fort);

    }

    public String gibStringfuertextArea(String dieser) {
        String erg = new String();
        SachbearbeiterEK sachB = SachbearbeiterEK.gib(dieser);
        String[] fortbildungen = Fortbildung.gibAlleFortbildungen();

        for (int i = 0; i < fortbildungen.length; i++) {
            System.out.println(erg);
            erg = erg + (fortbildungen[i] + "\t" + sachB.getStatus(sachB, Fortbildung.gib(fortbildungen[i])) + "\n");
        }

        System.out.println(erg);
        return erg;

    }

}
