import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by bearg on 4/30/2016.
 * Demonstrates the huge performance difference in using a Map to add and lookup
 * a large number of Products versus using an ArrayList.
 */
public class LookupTableComparison {

    private static final int ITERATIONS = 5;
    private static final int NUMBER_OF_PRODUCTS = 20_000;

    // list of products that will be added to each LookupTable implementation
    private static final List<Product> products = generateProducts();

    private static List<Product> generateProducts() {

        final List<Product> products = new ArrayList<>();
        final Random weightGenerator = new Random();
        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
            products.add(new Product("Product" + i,
                    10 + weightGenerator.nextInt(10), i));
        }

        Collections.shuffle(products);
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

    private static void runLookups(final ProductLookupTable lookupTable) {

        final List<Product> products = LookupTableComparison.products;
        System.out.println("Running lookups with " + lookupTable.getClass()
        .getSimpleName());

        // add and lookup NUMBER_OF_PRODUCTS products and print out
        // how long each iteration takes
        for (int i = 0; i < ITERATIONS; i++) {

            final long startTime = System.currentTimeMillis();

            for (Product product : products) {

                lookupTable.addProduct(product);
            }

            for (Product product : products) {
                final Product result = lookupTable.lookupById(product.getId());
                if (result != product) {

                    throw new IllegalStateException("Lookup Table returned wrong result");


                }
            }

            lookupTable.clear(); // clear out the passed in table before the next iteration

            System.out.println(System.currentTimeMillis() - startTime + "ms");
        }
    }

    /*
    public static void main(String[] args) {

        runLookups(new NaiveProductLookupTable());
        runLookups(new MapProductLookupTable());
    }
    */
}
