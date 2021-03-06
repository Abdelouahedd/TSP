package Interfaces;

import classes.Sommet;
import java.util.List;

@FunctionalInterface
public interface Trajectoire {
    List<Sommet> solve(List<Sommet> initialSolution);
}
