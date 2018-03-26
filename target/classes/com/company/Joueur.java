package com.company;

public class Joueur {

    private String pseudo;
    private String role;
    private int id;
    private int mmr;
    private int hr;
    private int time;

    public int getTime() {
        return time;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getHr() {

        return hr;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Joueur(String pseudo, int id, int mmr, int hr, String role, int time ) {
        this.pseudo = pseudo;
        this.id = id;
        this.mmr = mmr;
        this.hr = hr;
        this.role = role;
        this.time = time;
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
                ", role='" + role + '\'' +
                ", id=" + id +
                ", mmr=" + mmr +
                ", hr=" + hr +
                ", time=" + time +
                '}';
    }
}
