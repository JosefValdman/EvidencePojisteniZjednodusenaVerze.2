package cz.itnetwork.evidencepojistenizjednodusenaverze;

import java.util.Objects;

/**
 *
 * @author Josef Valdman
 */
public class Pojistenec {

    private String jmeno;
    private String prijmeni;
    private int telefon;
    private int vek;

    public Pojistenec(String jmeno, String prijmeni, int telefon, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.vek = vek;
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the prijmeni
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @return the telefon
     */
    public int getTelefon() {
        return telefon;
    }

    /**
     * @return the vek
     */
    public int getVek() {
        return vek;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " " + vek + " " + telefon;
    }

    // Pro přesné porovnání obsahu Pojistěnec v Evidenci aby nebyli (duplicitní pojištenci)
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.jmeno);
        hash = 67 * hash + Objects.hashCode(this.prijmeni);
        hash = 67 * hash + this.telefon;
        hash = 67 * hash + this.vek;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pojistenec other = (Pojistenec) obj;
        if (this.telefon != other.telefon) {
            return false;
        }
        if (this.vek != other.vek) {
            return false;
        }
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        return Objects.equals(this.prijmeni, other.prijmeni);
    }

}
