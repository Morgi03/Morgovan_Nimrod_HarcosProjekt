package hu.petrik.harcosprojekt;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    Harcosok harcosok = new Harcosok();
        try {
            harcosok.harcosokBeolvasas("harcosok.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        harcosok.felhasznaloiHarcosBekerese();
        harcosok.jatek();
    }
}
