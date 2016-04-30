import java.util.*;
import java.util.function.Predicate;

/**
 * Created by bearg on 4/30/2016.
 */
public class ViewsOverMaps {

    public static void main(String[] args) {

        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);
        idToProduct.put(4, ProductFixtures.floorPanel);

        System.out.println(idToProduct); // shortcut: type idToProduct.sout and hit enter
        System.out.println();

        // can get a Set view of all the keys in the Map. Keys are unique, so a Set is returned
        final Set<Integer> ids = idToProduct.keySet(); // keys in the Map are IDs of the Products
        System.out.println(ids);
        // Set is an inteface, but we're able to println (which calls String.valueOf,
        // which in turn calls toString()) on it because
        // Java has a special case for an interface that doesn't extend any other interface.
        // That interface implicitly includes all methods of Object, including toString().
        // Just like views for collections, if we make a modification to this Set, we'll see
        // the update reflected in the Set, and in the Map that we took a view of.

       // ids.remove(1); // remove key 1 and its associated value
        System.out.println(ids);
        System.out.println(idToProduct); // no longer contains key 1 and its associated value
        System.out.println();

        // ids.add(4) -- runtime error. jvm won't know what value to associate to the key.
        // and you can't do put on the ids view, because it's a Set, not a Map

        // can also get a Collection view (values don't have to be unique, unlike keys)
        // of all values in the Map. Collection is an interface, but this is not an instance
        // of an interface -- instead, products is a reference to any class that implements the
        // interface.
        final Collection<Product> products = idToProduct.values();
        System.out.println(products);
        System.out.println();


        // below we remove all of the specified Product(s) from the Map, and their associated keys.
        // removeAll takes a Collection, so we had to create a Collection even though here we only
        // wanted to remove a single Product type -- all the floorPanels in the Map.
        /*Collection<Product> itemToRemove = new ArrayList<>();
        itemToRemove.add(ProductFixtures.floorPanel);
        products.removeAll(itemToRemove);*/

        products.remove(ProductFixtures.floorPanel); // only removes one key-value pair
        System.out.println(products);
        System.out.println(idToProduct);
        System.out.println();

        // products.add(ProductFixtures.floorPanel); runtime error. jvm doesn't know what key to associate with

        // entrySet is a Set of key/value pairs. commonly used to iterate over elements
        // in the
        final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();

        for (Map.Entry<Integer, Product> entry: entries) {

            // can also set values in the Map
            entry.setValue(ProductFixtures.door); // sets all values to door

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();

        Java8MapEnhancements.runEnhancements();

    }
}
