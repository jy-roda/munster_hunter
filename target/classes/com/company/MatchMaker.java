package com.company;

import java.util.ArrayList;

public class MatchMaker {

    private ArrayList<Joueur> liste;
    private ArrayList<Joueur> dps = new ArrayList<>();
    private ArrayList<Joueur> heal = new ArrayList<>();
    private ArrayList<Joueur> tank = new ArrayList<>();



    public MatchMaker(ArrayList<Joueur> liste) {
        this.liste = liste;
        for (Joueur j : this.liste) {
            switch (j.getRole()) {
                case "DPS" : dps.add(j); break;
                case "Healer" : heal.add(j); break;
                case "Tank" : tank.add(j); break;
            }
        }
    }

    public ArrayList<Guilde> getTeams() {
        ArrayList<Guilde> teams = new ArrayList<>();
        while (teams.size() <= maxTeams()) {
            Joueur dpsJ1 = dps.get(0);
            Joueur dpsJ2 = dps.get(1);
            Joueur healJ = heal.get(0);
            Joueur tankJ = tank.get(0);
            for (Joueur healR : heal) {
                for (Joueur tankR : tank) {
                    for (int i = 0; i < dps.size(); i++) {
                        for (int j = i + 1; j < dps.size(); j++) {
                            double moyenne = (dpsJ1.getMmr() + dpsJ2.getMmr() + healJ.getMmr() + tankJ.getMmr()) / 4;
                            double new_moyenne = (dps.get(i).getMmr() + dps.get(j).getMmr() + healR.getMmr() + tankR.getMmr()) /4;
                            if (Math.abs(Main.getAverageMMR() - moyenne) > Math.abs(Main.getAverageMMR() - new_moyenne)) {
                                dpsJ1 = dps.get(i);
                                dpsJ2 = dps.get(j);
                                healJ = healR;
                                tankJ = tankR;
                            }
                        }
                    }
                }
            }
            Guilde g = new Guilde(dpsJ1); dps.remove(dpsJ1);
            g.addPlayer(dpsJ2); dps.remove(dpsJ2);
            g.addPlayer(healJ); heal.remove(healJ);
            g.addPlayer(tankJ); tank.remove(tankJ);
            teams.add(g);
        }
        return teams;
    }





    public int maxTeams() {
        return Math.min(Math.min(heal.size(), tank.size()), dps.size() / 2);
    }





}
