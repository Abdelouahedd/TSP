package main;

import classes.Arete;
import classes.Graphe;
import classes.Sommet;

public class Main {
    public static void main(String[] args) {
        Graphe graphe=new Graphe(4);
       graphe.generateGraphe();
        System.out.println(graphe);
        System.out.println("/**********************************/");

        for (Arete ae : graphe.getSortedAret()) {
            System.out.println(ae);
        }
        for (Sommet ae : graphe.initialeSolution()) {
            System.out.println(ae);
        }

    }
}
