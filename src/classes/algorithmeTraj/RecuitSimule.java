package classes.algorithmeTraj;

import classes.Graphe;
import classes.Sommet;

import java.util.List;
import java.util.Random;

public class RecuitSimule extends AlgorithmeTrajectoir {
    private static double TMAX=10e6;

    public RecuitSimule(Graphe graphe) {
        super(graphe);
    }

    @Override
    public List<Sommet> solve(List<Sommet> initialSolution) {
        List<Sommet> sommets=initialSolution;
        List<List<Sommet>> voisins;//list des voisins generer
        List<Sommet> voisinAvecCoutMin;//le voisin optimom
        double T=TMAX;//température initiale

        boolean conditionEquilibre=false;
        Random rand=new Random();
        while (T>1) {
            do {
                int j=rand.nextInt(graphe.getNbVille());
                voisins=generateVoisin(sommets, j);//géneration des voisin
                voisinAvecCoutMin=getVoisinAvecCoutMin(voisins);//choisir le meilleur voisin
                var r=Math.random();//géneration de 0<r<1
                if (r<fonctionBoltZmann(voisinAvecCoutMin, sommets, T)) {
                    sommets=voisinAvecCoutMin;
                    conditionEquilibre=true;
                }
            } while (! conditionEquilibre);
            T=T-100;//Modification de la températur
        }
        return sommets;
    }

    public double fonctionBoltZmann(List s, List ss, double t) {
        return Math.exp(- ((graphe.getCouts(s)-graphe.getCouts(ss)) / t));
    }
}
