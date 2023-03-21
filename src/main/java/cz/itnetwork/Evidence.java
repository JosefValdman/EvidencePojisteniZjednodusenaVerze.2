package cz.itnetwork.evidencepojistenizjednodusenaverze;

import java.util.LinkedList;

/**
 *
 * @author Josef Valdman
 */
public class Evidence {

    private UzivatelskeRozhrani ui;
    private Databaze databaze;
    private LinkedList<Pojistenec> evidence;
    private String jmeno;
    private String prijmeni;
    private int telefon;
    private int vek;

    public Evidence() {
        ui = new UzivatelskeRozhrani();
        databaze = new Databaze();
    }

    public void Program() {

        String prikaz = "";

        while (!prikaz.equals("4")) {
            VytiskniMenu();

            prikaz = ui.prikaz();

            switch (prikaz) {
                case "1":
                    //1 - Přidat nového pojištěnce
                    pridejPojisteneho();
                    break;

                case "2":
                    //2 - Vypsat všechny pojištěné
                    vypisVsechnyPojistene();
                    break;

                case "3":
                    //3 - Vyhledat pojištěného
                    vyhledejPojisteneho();
                    break;

                case "4":
                    //4 - Konec
                    System.out.println("Zavírám ");
                    //System.exit(0);
                    break;
            }
        }

    }

    private void VytiskniMenu() {
        System.out.println("--------------------------------");
        System.out.println("Evidence Pojištěných");
        System.out.println("--------------------------------\n");
        System.out.println("Vyberte si akci: ");
        System.out.println("1 - Přidat nového pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
    }

    private void pridejPojisteneho() {
        ziskejJmenoAPrijmeni();
        ziskejTelefonAVek();
        // Kontrola Evidence jestli je prázdná nebo již obsahuje stejný záznam
        if (databaze.jePrazdna()) {
            databaze.pridejZaznam(jmeno, prijmeni, telefon, vek);
        } else {
            Pojistenec zaznam = new Pojistenec(jmeno, prijmeni, telefon, vek);
            evidence = databaze.najdiZaznamy();
            int nalezeno = 0;
            for (int i = 0; i < evidence.size(); i++) {
                if (evidence.get(i).equals(zaznam)) {
                    nalezeno++;
                }
            }
            if (nalezeno == 0) {
                databaze.pridejZaznam(jmeno, prijmeni, telefon, vek);
            } else {
                System.out.println("\nJiž je v Evidenci. Pokračujte libovolnou klávesou...");
            }
        }
        ui.prikaz();
    }

    private void vypisVsechnyPojistene() {
        if (!databaze.jePrazdna()) {
            System.out.println("");
            evidence = databaze.najdiZaznamy();
            evidence.forEach(System.out::println);
        }
        dopln();
    }

    private void vyhledejPojisteneho() {
        if (!databaze.jePrazdna()) {
            ziskejJmenoAPrijmeni(); // jméno a příjmení
            evidence = databaze.najdiZaznamy();
            System.out.println("");
            int nalezeno = 0;
            for (int i = 0; i < evidence.size(); i++) {
                if (evidence.get(i).getJmeno().equals(jmeno) && evidence.get(i).getPrijmeni().equals(prijmeni)) {
                    System.out.println(evidence.get(i));
                    nalezeno++;
                }
            }
            if (nalezeno == 0) {
                System.out.println("\nNení v Evidenci!");
            }
        }
        dopln();
    }

    private void dopln() {
        if (databaze.jePrazdna()) {
            System.out.println("\nDatabáze je prázdna.");
        }
        System.out.println("\nPokračujte libovolnou klávesou...");
        ui.prikaz();
    }

    private void ziskejJmenoAPrijmeni() {
        jmeno = ui.zadejJmeno();
        prijmeni = ui.zadejPrijmeni();
    }

    private void ziskejTelefonAVek() {
        telefon = ui.zadejTelefon();
        vek = ui.zadejVek();
    }

}
