package classes.algorithmeTraj;

import Interfaces.Trajectoire;
import classes.Graphe;
import classes.Sommet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AlgorithmeTrajectoir implements Trajectoire {
    protected Graphe graphe;

    public AlgorithmeTrajectoir(Graphe graphe) {
        this.graphe=graphe;
    }

    /***
     * fonction switch2opt qui permette de
     * permuter de valuer dans l'indice i et j
     * @param chemain
     * @param i
     * @param j
     * @return list des sommets
     */
    public static List<Sommet> switch2opt(List<Sommet> chemain, int i, int j) {
        List<Sommet> chemainResult=new ArrayList<>(chemain);
        Sommet tmp=chemainResult.get(i);
        chemainResult.set(i, chemain.get(j));
        chemainResult.set(j, tmp);
        return chemainResult;
    }

    /***
     * fonction switch2opt qui permette de
     * permuter de valuer dans l'indice i et j
     * (i,j) aléatoir
     * @param chemain
     * @return list des sommets
     */
    public static List<Sommet> switch2opt(List<Sommet> chemain) {
        List<Sommet> chemainResult=new ArrayList<>(chemain);
        Random rand=new Random();
        int i=rand.nextInt(chemain.size()-1);
        int j=rand.nextInt(chemain.size()-1);
        while (i==j) j=rand.nextInt(chemain.size());
        Sommet tmp=chemainResult.get(i);
        chemainResult.set(i, chemain.get(j));
        chemainResult.set(j, tmp);
        return chemainResult;
    }

    /***
     * fonction switch3opt qui permette de
     * permuter des valeurs dans l'indice i et j et k
     * qui son deja generer aléatoirement
     * @param chemain
     * @return list des sommets
     */
    public static List<Sommet> switch3opt(List<Sommet> chemain) {
        Random random=new Random();
        List<Sommet> chemainResult=new ArrayList<>(chemain);
        int i=random.nextInt(chemain.size()-1);
        int j=random.nextInt(chemain.size()-1);
        int k=random.nextInt(chemain.size()-1);
        while (j==i) j=random.nextInt(chemain.size()-1);
        while (j==k || i==k) k=random.nextInt(chemain.size()-1);

        Sommet tmp=chemainResult.get(i);
        chemainResult.set(i, chemain.get(j));
        chemainResult.set(j, chemain.get(k));
        chemainResult.set(k, tmp);
        return chemainResult;
    }

    /***
     * fonction switch3opt qui permette de
     * permuter des valeurs dans l'indice i et j et k
     * qui son deja generer aléatoirement
     * @param chemain
     * @return list des sommets
     */
    public static List<Sommet> switch4opt(List<Sommet> chemain) {
        Random random=new Random();
        List<Sommet> chemainResult=new ArrayList<>(chemain);
        int i=random.nextInt(chemain.size()-1);
        int j=random.nextInt(chemain.size()-1);
        int k=random.nextInt(chemain.size()-1);
        int h=random.nextInt(chemain.size()-1);
        while (j==i) j=random.nextInt(chemain.size()-1);
        while (k==i || k==j) k=random.nextInt(chemain.size()-1);
        while (h==i || h==j || h==k) h=random.nextInt(chemain.size()-1);

        Sommet tmp=chemainResult.get(i);
        Sommet temp1=chemainResult.get(k);
        Sommet temp2=chemainResult.get(j);

        chemainResult.set(i, chemain.get(j));
        chemainResult.set(j, temp1);
        chemainResult.set(k, temp2);
        chemainResult.set(h, tmp);
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
    protected List<List<Sommet>> generateVoisin(List<Sommet> chemain, int indiceSwitch) {
        List<List<Sommet>> listsSommet=new ArrayList<>();
        for (int i=1; i<chemain.size(); i++) {
            listsSommet.add(switch2opt(chemain, indiceSwitch, i));
        }
        return listsSommet;
    }

    /**
     * @param chemain
     * @return list des voisin du chemain passer en argument
     */
    protected List<List<Sommet>> generateVoisin(List<Sommet> chemain) {
        List<List<Sommet>> listsSommet=new ArrayList<>();
        for (int i=1; i<chemain.size(); i++) {
//            listsSommet.add(switch2opt(chemain, indiceSwitch, i));
        }
        return listsSommet;
    }

}
