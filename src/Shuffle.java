import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bearg on 4/30/2016.
 */
public class Shuffle {

    public static void showIt() {
        final ArrayList<Product> products = new ArrayList<>();

        Product door = ProductFixtures.door;
        Product floorPanel = ProductFixtures.floorPanel;
        Product window = ProductFixtures.window;

        Collections.addAll(products, door, floorPanel, window);

        System.out.println(products);

        Collections.shuffle(products);
        System.out.println(products);

        Collections.shuffle(products);
        System.out.println(products);

        Collections.shuffle(products);
        System.out.println(products);
    }
}
