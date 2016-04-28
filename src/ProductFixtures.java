/**
 * Created by bearg on 4/25/2016.
 */
public class ProductFixtures {

    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);
    public static Product frame = new Product("Frame", 5);
    public static Product sink = new Product("Sink", 20);

    public static Supplier bobs = new Supplier("Bob's Household Supplies");
    public static Supplier kates = new Supplier("Kate's Home Goods");

    static {
        // Suppliers Bob and Kate both sell floors and doors
        // make Bob have only heavy products
        bobs.products().add(door);
        bobs.products().add(floorPanel);
        bobs.products().add(sink);

        // make Kate have only light products
        kates.products().add(window);
        kates.products().add(frame);
    }
}
