package main.java;

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
        this.stratum = stratum;
    }

    public int getNumPerson() {
        return numPerson;
    }

    public void setNumPerson(int numPerson) {
        this.numPerson = numPerson;
    }
}
