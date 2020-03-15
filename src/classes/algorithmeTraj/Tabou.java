package classes.algorithmeTraj;

import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * class Tabou
 * herite de la class AlgorithmeTrajectoir
 */
public class Tabou extends AlgorithmeTrajectoir {

    /**
     * constructeur
     *
     * @param graphe
     */
    public Tabou(Graphe graphe) {
        super(graphe);
    }

    /**
     * methode solve qui permet
     * de generer le meilleur chemain
     *
     * @param initialSolution
     * @return meilleur chemain
     */
    @Override
    public ArrayList<Sommet> solve(List<Sommet> initialSolution) {
        List<Sommet> sommets=initialSolution;//sommet
        int initCout=this.graphe.getCouts(sommets);//le cout initial
        List<List<Sommet>> voisins;//list des voisins generer
        List<Sommet> voisinAvecCoutMin;//le voisin optimom
        int coutVoisinMin;//le cout de voisin optimom
        List<List<Sommet>> tabou=new ArrayList<>();//le tableau Tabou
        int i=0;//nombre d'iteration
        int j=0;//l'indice de sommet pour la permutation

        while (i++<1000) {
            voisins=super.generateVoisin(sommets, j);//generation du voisin de l'indice j
            voisinAvecCoutMin=super.getVoisinAvecCoutMin(voisins);//le meilleur voisin
            coutVoisinMin=this.graphe.getCouts(voisinAvecCoutMin);//le cout du meilleur voisin
            if (! tabou.contains(voisinAvecCoutMin)) {//test si la solution etait deja pri
                tabou.add(sommets);
            }
            if (coutVoisinMin<initCout) {//changement du solution initil
                sommets=voisinAvecCoutMin;
                initCout=coutVoisinMin;
                j=0;
            } else {
                if (j >= this.graphe.getNbVille()-1) {//test si l'indice de permutation depasse la taille max
                    j=0;
                }
                j++;
            }
        }
        return (ArrayList<Sommet>) sommets;
    }
}
