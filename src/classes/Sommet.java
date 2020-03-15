package classes;

import java.util.List;

/**
 * @author ae
 * class Sommet
 */
public class Sommet implements Comparable {
    /**
     * l'index du sommet
     */
    private int index;
    private int nbrVisite=0;

    /**
     * Constructeur par un index
     *
     * @param index
     */
    public Sommet(int index) {
        this.index=index;
    }

    /**
     * getter index
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

    public void visit() {
        this.nbrVisite++;
    }

    public boolean isVisited() {
        return this.nbrVisite>2;
    }


    @Override
    public boolean equals(Object o) {
        Sommet sommet=(Sommet) o;
        return getIndex()==sommet.getIndex();
    }

    @Override
    public String toString() {
        return ""+index+"->";
    }

    @Override
    public int compareTo(Object visitSomme) {
        return index-((Sommet) visitSomme).index;
    }
}
