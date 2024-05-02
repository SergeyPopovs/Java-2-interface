package com.company;

import static com.company.AsteroidDialog.editObject;

public class Main {
    private static AsteroidDialog asteroidDialog;
    public static void main(String[] args) {
        com.company.comet Milky = new com.company.comet("Milky", 6, 45);
        com.company.AsteroidDialog.editObject(null, Milky);
        Milky.description();
        com.company.AsteroidDialog.editObject(null, Milky);
        Milky.description();
    }
}




