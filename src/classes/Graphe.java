package classes;

import java.util.*;

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

    public int getNbVille() {
        return nbVille;
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
    public Set<Arete> getSortedAret() {
        TreeSet<Arete> list=new TreeSet<>(Arete::compareTo);
        for (int i=0; i<nbVille; i++) {
            for (int j=i+1; j<nbVille; j++) {
                Sommet s1=new Sommet(i);
                Sommet s2=new Sommet(j);
                Arete aret=new Arete(s1, s2, this.graphe.get(i).get(j));
                list.add(aret);
            }
        }
        return list;
    }

/*    *//**
     * generer initial solution
     * @return une chemain
     *//*
    public List<Sommet> initialeSolution() {
        List<Sommet> listVisited=new ArrayList<>();
        for (Arete ar : getSortedAret()) {
            if (! listVisited.contains(ar.getDebut()) && ! listVisited.contains(ar.getVoisin())) {
                listVisited.add(ar.getDebut());
                listVisited.add(ar.getVoisin());
            }
        }
        return listVisited;
    }*/

}

