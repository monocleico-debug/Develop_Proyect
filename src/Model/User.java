package Model;
public class User {
    private int stratum;
    private int numperson;

    public User(int stratum, int numperson) {
        this.stratum = stratum;
        this.numperson = numperson;
    }

    public int getStratum() {
        return stratum;
    }

    public void setStratum(int stratum) {
        if (stratum >= 1 && stratum <= 6) {
            this.stratum = stratum;
        } else {
            System.out.println("Estrato inválido");
        }
    }

    public int getNumperson() {
        return numperson;
    }

    public void setNumperson(int numperson) {
        if (numperson > 0) {
            this.numperson = numperson;
        } else {
            System.out.println("Número inválido");
        }
    }
}
