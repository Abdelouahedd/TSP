package classes.algorithmeTraj;

import classes.Graphe;
import classes.Sommet;

import java.util.List;

/**
 * class Descendente
 *
 * @author ae
 */
public class Descendente extends AlgorithmeTrajectoir {


    /**
     * constructeur du class
     *
     * @param graphe
     */
    public Descendente(Graphe graphe) {
        super(graphe);
    }

    /**
     * le fonction solve qui nous a permet de génerer
     * une solution a partir d'un solution initiale
     * @param initialSolution
     * @return List des sommets
     */
    @Override
    public List<Sommet> solve(List<Sommet> initialSolution) {
        List<Sommet> sommets=initialSolution;
        int initCout=this.graphe.getCouts(sommets);
        List<List<Sommet>> voisins;
        List<Sommet> voisinAvecCoutMin;
        int coutVoisinMin;

        while (true) {
            voisins=super.generateVoisin(sommets,0);
            voisinAvecCoutMin=super.getVoisinAvecCoutMin(voisins);
            coutVoisinMin=this.graphe.getCouts(voisinAvecCoutMin);
            if (coutVoisinMin<initCout) {
                sommets=voisinAvecCoutMin;
                initCout=coutVoisinMin;
            } else {
                return sommets;
            }
        }
    }
}
