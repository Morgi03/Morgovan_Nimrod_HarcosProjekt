package hu.petrik.harcosprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Harcosok {
    private List<Harcos> harcosList;

    public Harcosok() {
        this.harcosList = new ArrayList<>();
    }

    public void getListOfHarcosok() {
        for (int i = 0; i < this.harcosList.size(); i++) {
            System.out.println((i + 1) + ". " + harcosList.get(i));
        }
    }

    private Harcos harcos;

    public void felhasznaloiHarcosBekerese() {
        String nev;
        int statuszsablon;
        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg a harcosod nevét:");
        nev = sc.nextLine();
        System.out.println("Add meg a harcosod státusz sablonját:");
        statuszsablon = sc.nextInt();
        sc.nextLine();
        this.harcos = new Harcos(nev, statuszsablon);
    }

    public void jatek() {
        boolean Kilep = false;
        Scanner sc = new Scanner(System.in);
        String valasz;
        int korszamlalo = 1;
        while (!Kilep) {
            korszamlalo++;
            System.out.println("Adja meg, hogy mit szeretne tenni!\na.) Megküzdeni egy harcossal\nb.) Gyógyulni\nc.) Kilépni");
            valasz = sc.nextLine().toLowerCase();
            if (korszamlalo % 3 == 0) {
                //...
            }
            if (valasz.equals("c")) {
                Kilep = true;
            } else if (valasz.equals("b")) {
                this.harcos.gyogyul();
            } else if (valasz.equals("a")) {
                this.getListOfHarcosok();
                System.out.println("Adja meg, hogy hanyadik sorszámú harcossal szeretne harcolni:");
                String temp = sc.nextLine();
                if (Character.isDigit(Integer.parseInt(temp)) && Integer.parseInt(temp) >= 1 && Integer.parseInt(temp) <= harcosList.size()) {
                    int index = Integer.parseInt(temp);
                    this.harcos.megkuzd(harcosList.get(index));
                } else {
                    System.err.println("Hiba! Érvénytelen számot, vagy nem számot adott meg!");
                }


            }
        }
    }

    public void harcosokBeolvasas(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] adatok = sor.split(";");
            Harcos harcos = new Harcos(adatok[0], Integer.parseInt(adatok[1]));
            this.harcosList.add(harcos);
            sor = br.readLine();
        }
        fr.close();
        br.close();
    }
}
