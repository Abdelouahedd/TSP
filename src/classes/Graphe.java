package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author abdelouahed ennouri
 * class Graphe
 */

public class Graphe {
    /**
     * attribut nbrVille
     * qui represete le nombre d'aretes dans une graphe
     */
    private final int nbVille;
    /**
     * graphe qui represente les poinds de chaque arete
     */
    private final ArrayList<ArrayList<Integer>> graphe;

    /**
     * @param nbVille
     */
    public Graphe(int nbVille) {
        this.nbVille=nbVille;
        this.graphe=new ArrayList();
        for (int i=0; i<nbVille; i++) {
            this.graphe.add(new ArrayList());
        }
    }

    /**
     * @return List des aretes
     */
    public ArrayList<ArrayList<Integer>> generateGraphe() {
        Random rand=new Random();
        for (int i=0; i<this.nbVille; i++) {
            for (int j=0; j<this.nbVille; j++) {
                int nbrRandom=rand.nextInt(100);
                if (i==j) {
                    graphe.get(i).add(0);
                } else if (j>i) {
                    graphe.get(i).add(j, nbrRandom);
                    graphe.get(j).add(i, nbrRandom);
                }
            }
        }
        return graphe;
    }

    /**
     * @return imlemente le collections Set des aretes
     */

    @Override
    public String toString() {
        String str="";
        for (int i=0; i<this.nbVille; i++) {
            for (int j=0; j<this.nbVille; j++) {
                str+=(""+this.graphe.get(i).get(j)+"\t\t");
            }
            str+=("\n");
        }

        return str;
    }

    /**
     * @return trier les arets
     * par ordre descendent
     */
    public List<Arete> getSortedAret() {
        List<Arete> list=new ArrayList<>();
        for (int i=0; i<nbVille; i++) {
            for (int j=i+1; j<nbVille; j++) {
                Sommet s1=new Sommet(i);
                Sommet s2=new Sommet(j);
                Arete aret=new Arete(s1, s2, this.graphe.get(i).get(j));
                list.add(aret);
            }
        }
        Collections.sort(list, Arete::compareTo);
        return list;
    }

    public int getPoid(int i, int j) {
        return this.graphe.get(i).get(j);
    }

    /**
     * @param chemain
     * @return le cout du chemain passer en argumet
     */
    public int getCouts(List<Sommet> chemain) {
        int cout=0;
        for (int i=0; i<chemain.size()-1; i++) {
            cout+=this.getPoid(chemain.get(i).getIndex(), chemain.get(i+1).getIndex());
        }
        cout+=this.getPoid(0, chemain.size()-1);
        return cout;
    }
}

