import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bearg on 4/30/2016.
 */
public class Sort {

    public static void showIt() {

        final ArrayList<Product> products = new ArrayList<>();

        Product door = ProductFixtures.door;
        Product floorPanel = ProductFixtures.floorPanel;
        Product window = ProductFixtures.window;

        Collections.addAll(products, door, floorPanel, window);
        System.out.println(products);

        // Collections.sort(products, Product.BY_NAME); use before Java 8
        products.sort(Product.BY_NAME); // using sort method of List interface for Java 8
        System.out.println(products);

        // Collections.sort(products, Product.BY_WEIGHT);
        products.sort(Product.BY_WEIGHT);
        System.out.println(products);

    }
}
