package org.example.analisi;

import java.util.Random;

public class Generate {
    Random r = new Random();

    public static Integer generateNumber(Random r){
        return r.nextInt(37);
    }
}
