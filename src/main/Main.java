package main;

import Interfaces.InitialSolution;
import Interfaces.Trajectoire;
import classes.Graphe;
import classes.Sommet;
import classes.algorithmeTraj.Descendente;
import classes.algorithmeTraj.RecuitSimule;
import classes.algorithmeTraj.Tabou;
import classes.initialSolution.InitialSolutionTrie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("/**************Matrice********************/");
        Graphe graphe=new Graphe(100);
        graphe.generateGraphe();
//        System.out.println(graphe);
        System.out.println("/***************Initial Solution*******************/");
        InitialSolution initialSolution=new InitialSolutionTrie();
        List<Sommet> init=initialSolution.initialeSolution(graphe);
        System.out.println("le cout du solution initial "+graphe.getCouts(init));
        System.out.println("/****************Cout Descendente******************/");
        long time=System.currentTimeMillis();
        Trajectoire descendente=new Descendente(graphe);
        List<Sommet> sommetList=descendente.solve(init);
//        System.out.println("Le temps d'execution descendente est "+((System.currentTimeMillis()-time)));
        System.out.println("cout optemiser descendente = "+graphe.getCouts(sommetList));
        System.out.println("Descendente = "+(graphe.getCouts(sommetList)*100)/graphe.getCouts(init));
        System.out.println("/****************Cout Tabou******************/");
        long timeT=System.currentTimeMillis();
        Trajectoire tabou=new Tabou(graphe);
        List<Sommet> sommetListT=tabou.solve(init);
//        System.out.println("Le temps d'execution tabou est "+((System.currentTimeMillis()-timeT)));
        System.out.println("cout optemiser tabou = "+graphe.getCouts(sommetListT));
        System.out.println("tabou %= "+(graphe.getCouts(sommetListT)*100)/graphe.getCouts(init));
        System.out.println("/****************Cout Recuit Simule******************/");
        long timeR=System.currentTimeMillis();
        Trajectoire recuitSimule=new RecuitSimule(graphe);
        List<Sommet> sommetListR=recuitSimule.solve(init);
//        System.out.println("Le temps d'execution est recuitSimule "+((System.currentTimeMillis()-timeR)));
        System.out.println("cout optemiser recuitSimule = "+graphe.getCouts(sommetListR));
        System.out.println("recuitSimule % = "+(graphe.getCouts(sommetListR)*100)/graphe.getCouts(init));
    }
}
