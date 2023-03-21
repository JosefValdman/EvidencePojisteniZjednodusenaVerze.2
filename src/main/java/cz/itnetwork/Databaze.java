package cz.itnetwork.evidencepojistenizjednodusenaverze;

import java.util.LinkedList;

/**
 * @author Josef Valdman
 */
public class Databaze {

    private LinkedList<Pojistenec> evidence = new LinkedList<>();

    public boolean jePrazdna() {
        return evidence.isEmpty();
    }

    public void pridejZaznam(String jmeno, String prijmeni, int telefon, int vek) {
        evidence.add(new Pojistenec(jmeno, prijmeni, telefon, vek));
        System.out.println("\nData byla uložena. Pokračujte libovolnou klávesou...");
    }

    public LinkedList<Pojistenec> najdiZaznamy() {
        return evidence;
    }

}
