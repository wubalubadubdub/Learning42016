import java.util.*;

/**
 * Created by bearg on 4/24/2016.
 */
public class CollectionConcepts {


    public static void main(String[] args){
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        // Collection products; is not type-safe -- anything could be added to it
        // and we could get a runtime exception if we try to get an element to
        // cast to String that is actually, say, an int.

        Collection<Product> products; // Product is a generic type parameter to Collection<E>
        // any object added to this Collection must now be a product

        products = new ArrayList<>(); // Product in the <> is optional after "new"
        // ArrayList implements List interface, which extends Collection interface, so
        // ArrayList must also implement Collection methods. We can assign any class
        // that implements Collection to a Collection variable, including ArrayList

        products.add(door);
        products.add(floorPanel);
        products.add(window);

        // ArrayList implements a toString() method that will list all objects. the
        // appearance of the { } in the output means you've printed out the Collection itself
        // System.out.println(products);

        // Any implementation of Collection has the methods used below
        // The Collection interface extends Iterable, so all subtypes of Collection
        // also implement the Iterable interface
        // An iterator is a cursor that lets us step through elements one at a time.
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) { // returns true if there's another element to look at
            // and false when we reach end of list
            Product product = productIterator.next();
            if (product.getWeight() > 20) {
                System.out.println(product); // can also do this part with foreach loop (read only)
            }
            else {
                productIterator.remove(); // but DON'T do this in foreach loop. it compiles (maybe), but
                // you shouldn't do it as it will cause unspecified behavior. the correct way
                // to do this is to use the Iterator.remove() method, as shown here
            }
        }

        // In java 5, special type of loop was introduced that works specifically for things which are
        // iterable, called the foreach loop. under the hood, this does the same thing we wrote above
        /*for (Product product : products) {
            if (product.getWeight() > 20) {
                System.out.println(product);
            }
            else {
                products.remove(product);  // causes ConcurrentModificationException
                // can't modify and iterate at the same time
            }
        }*/

        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(window));
        System.out.println(products.contains(door));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(window);
        otherProducts.add(door);

        // remove window and door from products Collection
        products.removeAll(otherProducts); //removeAll, containsAll, addAll take a Collection
        System.out.println(products);

      /*  final List<Integer> listInt = new ArrayList<>();
        for(int i = 1; i <= 10; i++) { // this loop doesn't iterate over the List, so it's ok to use it
            // to add elements
            listInt.add(i);
        }

        List<Integer> subListInt = listInt.subList(0, 5); // {1,2,3,4,5}. endIndex of subList is not inclusive
        subListInt.forEach(number -> System.out.println(number)); // forEach loop using a lambda*/

        // listInt = new ArrayList<>();  won't compile - cannot re-reference listInt


        // test -- Bob will supply only heavy products
        ProductCatalog catalogHeavy = new ProductCatalog();
        catalogHeavy.supply(ProductFixtures.bobs);
        SortedSet<Product> lightProducts = catalogHeavy.getLightVanProducts();
        SortedSet<Product> heavyProducts = catalogHeavy.getHeavyVanProducts();

        System.out.println("Printing Bob's");

        for (Product lightProduct : lightProducts) {
            System.out.println(lightProduct);
        }

        for (Product heavyProduct : heavyProducts) {
            System.out.println(heavyProduct);
        }

        System.out.println("Switching to Kate's");

        ProductCatalog catalogLight = new ProductCatalog();
        catalogLight.supply(ProductFixtures.kates);
        SortedSet<Product> lightProducts2 = catalogLight.getLightVanProducts();
        SortedSet<Product> heavyProducts2 = catalogLight.getHeavyVanProducts();

        for (Product lp : lightProducts2) {
            System.out.println(lp);
        }

        for (Product hp : heavyProducts2) {
            System.out.println(hp);
        }


    }




}
