package main;

import Interfaces.InitialSolution;
import Interfaces.Trajectoire;
import classes.Graphe;
import classes.Sommet;
import classes.algorithmeTraj.Descendente;
import classes.initialSolution.InitialSolutionTrie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("/**************Matrice********************/");
        Graphe graphe=new Graphe(500);
        graphe.generateGraphe();
        System.out.println(graphe);
        System.out.println("/***************Initial Solution*******************/");
        InitialSolution initialSolution=new InitialSolutionTrie();
        List<Sommet> init=initialSolution.initialeSolution(graphe);
        System.out.println("le cout du solution initial "+graphe.getCouts(init));
        System.out.println("/****************Cout******************/");
        long time=System.currentTimeMillis();
        Trajectoire descendente=new Descendente(graphe);
        List<Sommet> sommetList=descendente.solve(init);
        System.out.println("cout optemiser = "+graphe.getCouts(sommetList));
        System.out.println("Le temps d'execution est "+((System.currentTimeMillis()-time)/1000));
        System.out.println(sommetList);
    }
}
