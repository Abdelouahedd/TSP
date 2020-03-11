package classes.algorithmeTraj;

import Interfaces.Trajectoire;
import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;

/**
 * class Descendente qui implemente
 * l'interface Trajectoir
 *
 * @author ae
 */
public class Descendente implements Trajectoire {

    private Graphe graphe;

    /**
     * constructeur du class
     *
     * @param graphe
     */
    public Descendente(Graphe graphe) {
        this.graphe=graphe;
    }

    /***
     * fonction switchIndice qui permette de
     * permuter de valuer dans l'indice i et j
     * @param chemain
     * @param i
     * @param j
     * @return list des sommets
     */
    public static List<Sommet> switchIndice(List<Sommet> chemain, int i, int j) {
        List<Sommet> chemainResult=new ArrayList<>(chemain);
        Sommet tmp=chemainResult.get(i);
        chemainResult.set(i, chemain.get(j));
        chemainResult.set(j, tmp);
        return chemainResult;
    }

    /**
     * le fonction solve qui nous a permet de génerer
     * une solution a partir d'un solution initiale
     *
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
            //generation des voisins
            voisins=generateVoisin(sommets);
            voisinAvecCoutMin=getVoisinAvecCoutMin(voisins);
            coutVoisinMin=this.graphe.getCouts(voisinAvecCoutMin);
            if (coutVoisinMin<=initCout) {
                sommets=voisinAvecCoutMin;
                initCout=coutVoisinMin;
            } else {
                return sommets;
            }
        }
    }

    /**
     * @param voisins
     * @return le voisin qui a le min cout
     */
    private List<Sommet> getVoisinAvecCoutMin(List<List<Sommet>> voisins) {
        List<Sommet> voisinAvecCoutMin=voisins.get(0);
        int coutVoisin=this.graphe.getCouts(voisinAvecCoutMin);
        for (List<Sommet> voisin : voisins) {
            int cout=this.graphe.getCouts(voisin);
            if (cout<coutVoisin) {
                voisinAvecCoutMin=voisin;
                coutVoisin=cout;
            }
        }
        return voisinAvecCoutMin;
    }

    /**
     * @param chemain
     * @return list des voisin du chemain passer en argument
     */
    private List<List<Sommet>> generateVoisin(List<Sommet> chemain) {
        List<List<Sommet>> listsSommet=new ArrayList<>();
        for (int i=1; i<chemain.size(); i++) {
            listsSommet.add(switchIndice(chemain, 0, i));
        }
        return listsSommet;
    }

}
