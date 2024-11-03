package org.example;

public class Alfabeto {
    public static void stampaACorsivo() {
        int l = 6;  // Altezza della "A"
        int h = 12; // Larghezza della "A"
        int meta = (h / 2); // Punto centrale per calcolare le diagonali
        String c1 = "/";  // Carattere per il lato sinistro
        String c2 = "\\"; // Carattere per il lato destro
        String c3 = "_";  // Carattere per la barra orizzontale

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                if (j == meta - i && i>0) {
                    // Stampa "/" per il lato sinistro
                    System.out.print(c1);
                } else if (j == meta + i && i>0) {
                    // Stampa "\" per il lato destro
                    System.out.print(c2);
                } else if (i == l / 2 && j > meta - i && j < meta + i) {
                    // Stampa "_" per la barra orizzontale centrale
                    System.out.print(c3);
                } else {
                    // Spazi vuoti
                    System.out.print(" ");
                }
            }
            System.out.print("\n");  // Fine riga
        }
    }
}

