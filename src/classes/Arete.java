package classes;

import java.util.Objects;

/**
 * @author abdelouahed ennouri
 * class Arete qui represente
 * une arete de deux sommets
 */
public class Arete implements Comparable<Arete> {
    /**
     * attribut poind
     */
    private int poind;
    /**
     * attributs debut et voisin
     * representent deux Sommet
     */
    private Sommet debut;
    private Sommet voisin;

    /**
     * constructor
     *
     * @param debut  de type Sommet
     * @param voisin de type Sommet
     * @param poind
     */
    public Arete(Sommet debut, Sommet voisin, int poind) {
        this.debut=debut;
        this.voisin=voisin;
        this.poind=poind;
    }

    /**
     * @return Sommet
     */
    public Sommet getDebut() {
        return debut;
    }

    /**
     * @return Sommet
     */
    public Sommet getVoisin() {
        return voisin;
    }

    /**
     * @return le poind
     */
    public int getPoind() {
        return poind;
    }

    @Override
    public String toString() {
        return "Arete{"+
                "debut="+debut+
                ", voisin="+voisin+
                ",poind="+poind+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Arete arete=(Arete) o;
        if (this==o) return true;
        if (! (o instanceof Arete)) return false;
        if ((Objects.equals(getDebut(), arete.getDebut()) &&
                Objects.equals(getVoisin(), arete.getVoisin()))) {
            return true;
        } else if ((Objects.equals(getDebut(), arete.getVoisin()) &&
                Objects.equals(getDebut(), arete.getVoisin()))) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Arete arete) {
        if (this.poind!=arete.poind) {
            return this.poind-arete.poind;
        }
        if (! this.debut.equals(arete.getDebut())) {
            return this.debut.getIndex()-arete.getDebut().getIndex();
        }
        if (! this.voisin.equals(arete.getVoisin())) {
            return this.voisin.getIndex()-arete.getVoisin().getIndex();
        }
        return 0;
    }
}
