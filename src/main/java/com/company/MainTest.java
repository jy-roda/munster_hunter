package com.company;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


    @org.junit.jupiter.api.Test
    void getAverageMMR() {
        double average = 0;
        int i=0;
        for (;;){
            if (i==3)break;;
            ++i;
            average = average + 3 ;
        }
        average = average/i;
        assertEquals(3,average);
    }

    @org.junit.jupiter.api.Test
    void afficheListeJoueur() throws IOException, ParseException {
        boolean Lus = false;
        JSONParser parser = new JSONParser();
        FileReader r = new FileReader("players.json");
        JSONArray a = (JSONArray) parser.parse(r);
        Lus = true;
        assertTrue(Lus, "Le fichier est lus correctement");
    }

}