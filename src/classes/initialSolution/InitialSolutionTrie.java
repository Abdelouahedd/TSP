package classes.initialSolution;

import Interfaces.InitialSolution;
import classes.Arete;
import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;

public class InitialSolutionTrie implements InitialSolution {

    /**
     * generer initial solution
     * a partir de la méthode
     * de trie du graphe et prendre
     * les sommet qui ont visiter au moins
     * 2 fois
     *
     * @return une chemain
     */
    @Override
    public List<Sommet> initialeSolution(Graphe graphe) {
        List<Sommet> listVisited=new ArrayList<>();
        for (Arete ar : graphe.getSortedAret()) {
            if (ar.getDebut().isVisited() || ar.getVoisin().isVisited()) {
                continue;
            } else {
                choisirAret(listVisited, ar);
            }
        }
        return listVisited;
    }

    /**
     * cette fonction permet d'ajouter
     * une aret a mon list
     * @param listVisited
     * @param ar
     */
    private void choisirAret(List<Sommet> listVisited, Arete ar) {
        ar.getDebut().visit();
        ar.getVoisin().visit();
        if (! listVisited.contains(ar.getDebut())) {
            listVisited.add(ar.getDebut());
        }
        if (! listVisited.contains(ar.getVoisin())) {
            listVisited.add(ar.getVoisin());
        }
    }
}
