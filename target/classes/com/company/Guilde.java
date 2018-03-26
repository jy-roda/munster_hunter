package com.company;

import java.util.LinkedList;

public class Guilde {

    LinkedList<Joueur> joueurs;

    public Guilde(Joueur j) {
        joueurs = new LinkedList<>();
        joueurs.add(j);
    }

    public void addPlayer(Joueur j) {
        joueurs.add(j);
    }

    public void removePlayer(Joueur j) {
        joueurs.remove(j);
    }

    public Joueur getAdmin() {
        return joueurs.getFirst();
    }

    public LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Double getMMR() {
        double mmr = 0;
        for (Joueur j : joueurs) {
            mmr += j.getMmr();
        }
        return mmr / 4;
    }


    @Override
    public String toString() {
        return "Guilde de " + joueurs.get(0).getPseudo() + ", MMR moyen : " + getMMR();
    }
}
