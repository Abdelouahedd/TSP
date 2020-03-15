package classes.algorithmeTraj;

import classes.Graphe;
import classes.Sommet;
import java.util.List;

public class VNS extends AlgorithmeTrajectoir {

    public VNS(Graphe graphe) {
        super(graphe);
    }

    @Override
    public List<Sommet> solve(List<Sommet> initialSolution) {
        List<Sommet> sommets=initialSolution;
        int initCout=this.graphe.getCouts(sommets);
        List<Sommet> voisinAvecCoutMin;
        List<Sommet> voisinAvecDes;

        int coutVoisinAvecDes;
        int k=0;
        int iter=0;
        while (iter++<1000000) {
            while (k<=4) {
                voisinAvecCoutMin=generationVoisin(k, sommets);
                voisinAvecDes=new Descendente(graphe).solve(voisinAvecCoutMin);
                coutVoisinAvecDes=graphe.getCouts(voisinAvecDes);
                if (coutVoisinAvecDes<initCout) {
                    sommets=voisinAvecDes;
                    initCout=coutVoisinAvecDes;
                    k=1;
                } else {
                    k++;
                }
            }
        }
        return sommets;
    }

    public List<Sommet> generationVoisin(int k, List<Sommet> chemain) {
        if (k==2) return AlgorithmeTrajectoir.switch2opt(chemain);
        if (k==3) return AlgorithmeTrajectoir.switch3opt(chemain);
        if (k==4) return AlgorithmeTrajectoir.switch4opt(chemain);
        return AlgorithmeTrajectoir.switch2opt(chemain);
    }
}
