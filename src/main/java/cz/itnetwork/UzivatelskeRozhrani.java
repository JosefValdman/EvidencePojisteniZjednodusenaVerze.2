package cz.itnetwork.evidencepojistenizjednodusenaverze;

import java.util.Scanner;

/**
 *
 * @author Josef Valdman
 */
public class UzivatelskeRozhrani {

    private Scanner sc = new Scanner(System.in);
    boolean jeSpravne; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
    private Validace validace;

    public UzivatelskeRozhrani() {
        validace = new Validace();
    }

    public String prikaz() {
        return sc.nextLine();
    }

    public String zadejJmeno() { // jméno
        jeSpravne = false; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
        String testovaciJmeno = "";
        while (!jeSpravne) {
            System.out.println("Zadejte jméno pojištěného: ");
            testovaciJmeno = sc.nextLine();
            jeSpravne = validace.overeni(testovaciJmeno);
        }
        return testovaciJmeno;
    }

    public String zadejPrijmeni() { // příjmení
        jeSpravne = false; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
        String testovaciPrijmeni = "";
        while (!jeSpravne) {
            System.out.println("Zadejte příjmení: ");
            testovaciPrijmeni = sc.nextLine();
            jeSpravne = validace.overeni(testovaciPrijmeni);
        }
        return testovaciPrijmeni;
    }

    public int zadejTelefon() { // telefon
        jeSpravne = false; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
        int telefon = 0;
        while (!jeSpravne) {
            try {
                System.out.println("Zadejte telefoní číslo: ");
                telefon = Integer.parseInt(sc.nextLine());
                if (telefon < 1000000000 && telefon > 100000000) {
                    jeSpravne = true; //Nastavení booleanu jeSpravne na true, které ukončení zacyklení cyklu while
                } else {
                    System.out.println("Nesprávný počet znaků!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadaná hodnota není číslo!");
            }
        }
        return telefon;
    }

    public int zadejVek() { // vek
        jeSpravne = false; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
        int vek = 0;
        while (!jeSpravne) {
            try {
                System.out.println("Zadejte věk: ");
                vek = Integer.parseInt(sc.nextLine());
                if (!((vek <= 0) && (vek > 130))) {
                    jeSpravne = true; //Nastavení booleanu jeSpravne na true, které ukončení zacyklení cyklu while
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadaná hodnota není číslo!");
            }
        }
        return vek;
    }

}
