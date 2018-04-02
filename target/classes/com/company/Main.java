package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.lang.Math.nextUp;
import static java.lang.Math.random;
import static java.lang.Math.toIntExact;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    static ArrayList<Joueur> joueurs;
    public TextArea liste;
    public Label liste2;
    public Button Lancer;

    public static   void main(String[] args) throws IOException {
        try {
            launch(args);

            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static double getAverageMMR() {
        double average = 0;
        for (Joueur j : joueurs){
            average += j.getMmr();
        }
        return ( average / joueurs.size());
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Monster Hunter");

        stage.setScene(scene);

        stage.show();

    }

    public void MatchMaking(ActionEvent actionEvent) {
        liste.setText("");
        StringBuilder Guilde = new StringBuilder(" ");
        MatchMaker matchMaker = new MatchMaker(joueurs);
        //System.out.println("Nombre d'équipes max : " + matchMaker.maxTeams());
        ArrayList<Guilde> teams = matchMaker.getTeams();
        for (Guilde g : teams) {
            Guilde.append(g.toString() + '\n' + "Membres de cette Guilde : " + '\n' + g.getJoueurs() + '\n' );
        }
        liste.setText(String.valueOf(Guilde));
    }
    public void AfficheListeJoueur (ActionEvent actionEvent) throws IOException, ParseException {
        liste.setText(" ");
        joueurs = new ArrayList<Joueur>();
        JSONParser parser = new JSONParser();
        FileReader r = new FileReader("players.json");
        JSONArray a = (JSONArray) parser.parse(r);
        StringBuilder listeDesJoueur = new StringBuilder(" ");

        int cpt = 0;
        for (Object o : a) {
            if (cpt == 4 ){
                cpt = 0;
            }
            cpt ++;
            int rand = (int) (Math.random() * ( 2000 - 100));
            JSONObject player = (JSONObject) o;
            //Joueur(String pseudo, int id, int mmr, int hr, Role role) {
            Joueur j = new Joueur((String) player.get("playerID"),  toIntExact((Long)player.get("id")),0,
                    toIntExact((Long)player.get("HR")), (String) player.get("role"), toIntExact((Long)player.get("time")));
            j.setMmr(rand);
            listeDesJoueur.append(j.toString());
            liste.setText(String.valueOf(listeDesJoueur));
            joueurs.add(j);
            Lancer.setVisible(true);
        }

    }
}