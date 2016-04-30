import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

/**
 * Created by bearg on 4/24/2016.
 */
public class Product {

    /**
     * Comparator is an interface that defines a single method, compare,
     * which returns a negative int, zero, or a positive int if arg1 is
     * less than, equal to, or greater than arg2 in the sort order.
     * Comparator is a way of defining an ordering. Below, we have used
     * the static method comparing, defined on the Comparator interface.
     * It builds a Comparator and says to use the getWeight() method to
     * compare arg1 and arg2. The :: is called a method reference, which
     * is a java 8 feature.
     */

    public static final Comparator<Product> BY_WEIGHT =
            comparing(Product::getWeight);

    public static final Comparator<Product> BY_NAME =
            comparing(Product::getName);

    /**
     * Below is the way to do in this before java 8, which uses an
     * anonymous inner class
     *
     *  public static final Comparator<Product> BY_WEIGHT =
     *  new Comparator<Product>() {
     *
     *      public int compare(Product p1, Product p2) {
     *          return Integer.compare(p1.getWeight(), p2.getWeight()); // use Integer's compare method
     *      }
     */

    private final String name;
    private final int weight;
    private int id;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() { return id; }

    public Product(String name, int weight, int id) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +                // Product{
                "name='" + name + '\'' +  // name='(name)'
                ", weight=" + weight +  // , weight=(weight)}
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //both point to the same object in memory. they're equal

        // if the Object is null or the Objects aren't from the same class, they're not equal
        if (o == null || getClass() != o.getClass()) return false;

        // otherwise, use the values in the fields to check for equality
        Product product = (Product) o;

        if (weight != product.weight) return false;
        // return name != null ? name.equals(product.name) : product.name == null; old way
        return Objects.equals(name, product.name);

    }

    @Override
    public int hashCode() {
        /* int result = name != null ? name.hashCode() : 0;
        result = 31 * result + weight;
        return result; */ // old way

        return Objects.hash(name, weight);
    }
}
