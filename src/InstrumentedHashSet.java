import java.util.HashSet;

/**
 * Created by bearg on 5/14/2016.
 * This class, taken from Effective Java 2nd ed., demonstrations
 * the potential pitfalls of inheritance from classes not designed
 * for it, and why we should use composition instead wherever possible.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    // number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }
}
