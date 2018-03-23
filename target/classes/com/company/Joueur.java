package com.company;

public class Joueur {

    private String pseudo;
    private int id;
    private int mmr;


    public Joueur(String pseudo, int id, int mmr) {
        this.pseudo = pseudo;
        this.id = id;
        this.mmr = mmr;
    }


    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }

    public int getMmr() {
        return mmr;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "pseudo='" + pseudo + '\'' +
                ", id=" + id +
                ", mmr=" + mmr +
                '}';
    }
}
