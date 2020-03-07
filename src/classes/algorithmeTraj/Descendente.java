package classes.algorithmeTraj;

import Interfaces.Trajectoire;
import classes.Arete;
import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;

public class Descendente implements Trajectoire {
    @Override
    public ArrayList<Sommet> solve(List<Sommet>initialeSolution) {
        return null;
    }

    private int getCouts(Graphe graphe){
        List<Sommet>initialeSol = this.initialeSolution(graphe);
        List<Sommet>Voisin = new ArrayList<>();

        for (int i=0; i<graphe.getNbVille(); i++) {
            for (int j=0; j<graphe.getNbVille(); j++) {

            }
        }

        return 0;
    }
    /**
     * generer initial solution
     * @return une chemain
     */
    public List<Sommet> initialeSolution(Graphe graphe) {
        List<Sommet> listVisited=new ArrayList<>();
        for (Arete ar : graphe.getSortedAret()) {
            if (! listVisited.contains(ar.getDebut()) && ! listVisited.contains(ar.getVoisin())) {
                listVisited.add(ar.getDebut());
                listVisited.add(ar.getVoisin());
            }
        }
        return listVisited;
    }
}
