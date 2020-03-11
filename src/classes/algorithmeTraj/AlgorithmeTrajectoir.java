package classes.algorithmeTraj;

import Interfaces.Trajectoire;
import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgorithmeTrajectoir implements Trajectoire {
    protected Graphe graphe;

    public AlgorithmeTrajectoir(Graphe graphe) {
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
     * @param voisins
     * @return le voisin qui a le min cout
     */
    protected List<Sommet> getVoisinAvecCoutMin(List<List<Sommet>> voisins) {
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
    protected List<List<Sommet>> generateVoisin(List<Sommet> chemain,int indiceSwitch) {
        List<List<Sommet>> listsSommet=new ArrayList<>();
        for (int i=1; i<chemain.size(); i++) {
            listsSommet.add(switchIndice(chemain, indiceSwitch, i));
        }
        return listsSommet;
    }
}
