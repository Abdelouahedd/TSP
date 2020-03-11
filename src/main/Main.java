package main;

import Interfaces.InitialSolution;
import Interfaces.Trajectoire;
import classes.Graphe;
import classes.Sommet;
import classes.algorithmeTraj.Descendente;
import classes.algorithmeTraj.Tabou;
import classes.initialSolution.InitialSolutionTrie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("/**************Matrice********************/");
        Graphe graphe=new Graphe(100);
        graphe.generateGraphe();
        System.out.println(graphe);
        System.out.println("/***************Initial Solution*******************/");
        InitialSolution initialSolution=new InitialSolutionTrie();
        List<Sommet> init=initialSolution.initialeSolution(graphe);
        System.out.println("le cout du solution initial "+graphe.getCouts(init));
        System.out.println("/****************Cout Descendente******************/");
        long time=System.currentTimeMillis();
        Trajectoire descendente=new Descendente(graphe);
        List<Sommet> sommetList=descendente.solve(init);
        System.out.println("Le temps d'execution est "+((System.currentTimeMillis()-time)/1000));
        System.out.println("cout optemiser = "+graphe.getCouts(sommetList));
        System.out.println("/****************Cout Tabou******************/");
        long timeT=System.currentTimeMillis();
        Trajectoire tabou=new Tabou(graphe);
        List<Sommet> sommetListT=tabou.solve(init);
        System.out.println("Le temps d'execution est "+((System.currentTimeMillis()-timeT)/1000));
        System.out.println("cout optemiser = "+graphe.getCouts(sommetListT));

    }
}
