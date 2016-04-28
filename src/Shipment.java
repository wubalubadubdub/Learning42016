import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by bearg on 4/25/2016.
 */
public class Shipment implements Iterable<Product> {

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int PRODUCT_NOT_PRESENT = -1;

    private final List<Product> products = new ArrayList<>(); // multiple inheritance
    // from class and interface. iterating over this iterates over the shipment,
    // shipment impl. Iterable<Product> but is not a collection.

    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;

    public void add(Product product) {
         products.add(product);
    }

    public void prepare() {

        // sort list of products by weight
        products.sort(Product.BY_WEIGHT); // Comparator is an interface that
        // defines ordering. above is used in java 8. for earlier, use

        // Collections.sort(products, Product.BY_WEIGHT);

        // find product index that needs heavy van
        int splitPoint = findSplitPoint();

        // assign views of product list for heavy and light vans
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());
    }

    private int findSplitPoint() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }

        return 0;
    }

    public void replace(Product oldProduct, Product newProduct) {

        int index = products.indexOf(oldProduct);
        if (index != PRODUCT_NOT_PRESENT) {
            products.set(index, newProduct);
        }

    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    /* Below two methods commented out are default methods in the
    Iterable interface. default methods must be implemented, but this
    can now be done within the interface. it's a default implementation
    used if the class doesn't provide an implementation for the method.
    if we override the two default methods with the code below, the methods
    wouldn't do anything. commenting them out means we use the default implementations.

    @Override
    public void forEach(Consumer<? super Product> action) {

    }

    @Override
    public Spliterator<Product> spliterator() {
        return null;
    }*/

    @Override
    public Iterator<Product> iterator() { // must be implemented in class
        return products.iterator();
    }
}
