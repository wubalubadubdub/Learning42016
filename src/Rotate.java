import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by bearg on 4/30/2016.
 */
public class Rotate {

    public static void showIt() {
        final ArrayList<Product> products = new ArrayList<>();

        Product door = ProductFixtures.door;
        Product floorPanel = ProductFixtures.floorPanel;
        Product window = ProductFixtures.window;

        Collections.addAll(products, door, floorPanel, window);

        final Product firstProductAlphabetically =
                Collections.min(products, Product.BY_NAME);

        System.out.println(products);
        System.out.println();

        Collections.rotate(products, 1);
        System.out.println(products);
        System.out.println();

        Collections.rotate(products, 1);
        System.out.println(products);
        System.out.println();

        Collections.rotate(products, 1);
        System.out.println(products);
    }
}
