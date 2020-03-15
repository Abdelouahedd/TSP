package classes.initialSolution;

import Interfaces.InitialSolution;
import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArbitraireMethode implements InitialSolution {
    private Graphe graphe;

    public ArbitraireMethode(Graphe graphe) {
        this.graphe=graphe;
    }

    /**
     * methode qui choisir un sommet de départ arbitraire
     * @return indice de sommet
     */

    public Sommet sommetDepart() {
        int sommet=new Random().nextInt(graphe.getNbVille()-1);
        return new Sommet(sommet);
    }


    /**
     * methode qui retourne la plus proche voision
     * @param sommet
     * @param sommets
     * @return indice de la plus proche voisin
     */

    public Sommet plusProcheVoisin(Sommet sommet, ArrayList<Sommet> sommets) {
        int min=1000000000;
        int indicePlusProcheVoisin=0;
        for (int j=0; j<this.graphe.getNbVille(); j++) {
            if ((graphe.getPoid(sommet.getIndex(), j)<=min) &&
                    (sommet.getIndex()!=j) && (! sommets.contains(j))) {
                min=graphe.getPoid(sommet.getIndex(), j);
                indicePlusProcheVoisin=j;
            }
        }
        return new Sommet(indicePlusProcheVoisin);
    }


    @Override
    public List<Sommet> initialeSolution(Graphe graphe) {
        ArrayList<Sommet> sommets=new ArrayList<>();
        sommets.add(sommetDepart());
        Sommet plusProchVoisin;
        while (true) {
            if (sommets.size()<graphe.getNbVille()) {
                plusProchVoisin=plusProcheVoisin(sommets.get(sommets.size()-1), sommets);
                sommets.add(plusProchVoisin);
            } else {
                break;
            }
        }
        sommets.add(sommets.get(0));
        return sommets;
    }

}
