package Model;
public class User {
    private int stratum;
    private int numPerson;

    public User(int stratum, int numPerson) {
        this.stratum = stratum;
        this.numPerson = numPerson;
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
        return numPerson;
    }

    public void setNumperson(int numPerson) {
        if (numPerson > 0) {
            this.numPerson = numPerson;
        } else {
            System.out.println("Número inválido");
        }
    }
}