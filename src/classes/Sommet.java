package classes;

/**
 * @author ae
 * class Sommet
 */
public class Sommet implements Comparable {
    /**
     * l'index du sommet
     */
    private int index;

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

    @Override
    public boolean equals(Object o) {
        Sommet sommet=(Sommet) o;
        return getIndex()==sommet.getIndex();
    }

    @Override
    public String toString() {
        return "Sommet{"+
                "index = "+index+
                '}';
    }

    @Override
    public int compareTo(Object visitSomme) {
        return index-((Sommet) visitSomme).index;
    }
}
