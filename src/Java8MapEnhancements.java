import java.util.HashMap;

/**
 * Created by bearg on 4/30/2016.
 */
public class Java8MapEnhancements {

    public static void runEnhancements() {
        final Product defaultProduct = new Product(  // name, id, weight
                "Whatever the customer wants", -1,  100);

        final HashMap<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        // getOrDefault doesn't modify underlying Map. It either gets the value
        // for the specified key or returns the specified default value.
        /*final Product result = idToProduct.getOrDefault(10, defaultProduct);
        System.out.println(result);
        System.out.println(idToProduct.get(10));
        System.out.println();*/

        // replace method returns the old value. returns null if key doesn't exist.
        /*Product result = idToProduct.replace(1, new Product("Big Door", 50, 1));
        System.out.println(result);
        System.out.println(idToProduct.get(1));*/

        // replaceAll takes a Bifunction<K,V,V> -- a function that takes two args,
        // a key and a value, and returns a value. we pass in a lambda for
        // the bifunction that will add 10 to the weight of the Product.

        System.out.println(idToProduct); // before

        idToProduct.replaceAll((id, oldProduct) ->
        new Product(oldProduct.getName(), oldProduct.getWeight() + 10,
                oldProduct.getId()));

        System.out.println(idToProduct); // after

        // if value is in map, return it. otherwise, call this function to
        // produce a new k/v pair. takes a key and a Function<? super K, ? extends V>
        // to produce the new value.
        Product result = idToProduct
                .computeIfAbsent(10, id -> new Product("Custom Product", id, 10 ));

        System.out.println(result);
        System.out.println(idToProduct);

        // can use forEach and pass it a BiConsumer to operate on. Here, we'll
        // use it to neatly print out the key/value pairs in the Map.
        idToProduct.forEach((key, value) ->
        {
            System.out.println(key + " -> " + value);
        });
    }
}
