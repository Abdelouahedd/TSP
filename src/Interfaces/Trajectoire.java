package Interfaces;

import classes.Sommet;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Trajectoire {
    ArrayList<Sommet> solve(List<Sommet> initialeSolution);
}
