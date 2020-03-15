package classes.metaHeuristiquePopulation;

import Interfaces.AlgoPopulation;
import classes.Graphe;
import classes.Sommet;

import java.util.List;

public class AlogoGenitique implements AlgoPopulation {
    private Graphe graphe;

    public AlogoGenitique(Graphe graphe) {
        this.graphe=graphe;
    }

    @Override
    public List<Sommet> solve(List<Sommet> initialSolution) {
        return null;
    }

    @Override
    public List<Sommet> crossover(List<Sommet> S1, List<Sommet> S2) {
        return null;
    }

    @Override
    public List<List<Sommet>> genererPopulation(List<Sommet> S) {
        return null;
    }
}
