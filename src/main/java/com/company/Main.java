package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import static java.lang.Math.random;
import static java.lang.Math.toIntExact;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    static ArrayList<Joueur> joueurs;


    public static void main(String[] args) {
	    // write your code here

        joueurs = new ArrayList<Joueur>();

        /*  Imports en JSON

            JSONObject object = new JSONObject(theString);
            JSONArray results = object.getJSONArray("items");
            JSONObject videoData = results.getJSONObject(0);
            JSONObject videoID = videoData.getJSONObject("id");
            if (videoID.getString("kind").equals("youtube#video")) {

         */
        JSONParser parser = new JSONParser();
        try {
            FileReader r = new FileReader("players.json");
            JSONArray a = (JSONArray) parser.parse(r);

            for (Object o : a) {
                int rand = (int) (Math.random() * ( 2000 - 100));
                JSONObject player = (JSONObject) o;
                Joueur j = new Joueur((String) player.get("playerID"),  toIntExact((Long)player.get("id")),0 );
                j.setMmr(rand);
                System.out.println(j.toString());
                joueurs.add(j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public double getAverageMMR() {
        double average = 0;
        for (Joueur j : joueurs){
            average += j.getMmr();
        }
        return ( average / joueurs.size());
    }


}
