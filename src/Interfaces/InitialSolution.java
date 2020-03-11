package Interfaces;

import classes.Graphe;
import classes.Sommet;

import java.util.List;

@FunctionalInterface
public interface InitialSolution {
     List<Sommet> initialeSolution(Graphe graphe);
}
