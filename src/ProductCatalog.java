import java.util.*;

/**
 * Created by bearg on 4/25/2016.
 */
public class ProductCatalog implements Iterable<Product> {

    // if a Product weighs more than 20, it needs the heavy van
    private static final int LIGHT_VAN_CUTOFF_WEIGHT = 20;

    // needs to be declared as SortedSet and not just Set so we have access
    // to SortedSet methods
    private final SortedSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

    public void supply(Supplier supplier) {

        products.addAll(supplier.products()); // pass in list of products
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator(); // return Iterator of underlying collection - Set
    }

    public SortedSet<Product> getLightVanProducts() {
        Product lightestHeavyVanProduct = findLightestHeavyVanProduct();

        if (lightestHeavyVanProduct != null) {
            return products.headSet(lightestHeavyVanProduct); // exclusive to
        } else { // all Products go in light van
            return products;
        }

    }
    public SortedSet<Product> getHeavyVanProducts() {
        Product lightestHeavyVanProduct = findLightestHeavyVanProduct();

        if (lightestHeavyVanProduct != null) {
            return products.tailSet(lightestHeavyVanProduct); // inclusive from
        } else { // no Products go in heavy van -- return a new, empty set
             return new TreeSet<Product>(Product.BY_WEIGHT);
        }
    }



    private Product findLightestHeavyVanProduct() {

        // find the first Product weighing 20 or more and return it.
        // Products were already sorted by weight when we passed the
        // Product.BY_WEIGHT comparator to TreeSet.
        for (Product product : products) {
            if (product.getWeight() >= LIGHT_VAN_CUTOFF_WEIGHT) {
                return product;
            }
        }
        return null;
    }
}
