import java.util.HashMap;
import java.util.Map;

/**
 * Created by bearg on 4/30/2016.
 */
public class MapProductLookupTable implements ProductLookupTable {

    private final Map<Integer, Product> idToProduct = new HashMap<>();

    @Override
    public Product lookupById(final int id) {
        return idToProduct.get(id); // look up the value Product with key id
        // returns null if there's no Product associated with that id
    }

    @Override
    public void addProduct(final Product productToAdd) {

        // check if product ID is already a key
        final int id = productToAdd.getId();
        if (idToProduct.containsKey(id)) {

            throw new IllegalArgumentException("Unable to add product. " +
                    "Duplicate id for " + productToAdd);
        }

        // if it isn't, put the <id, Product> pair into the Map.
        idToProduct.put(id, productToAdd);
    }

    @Override
    public void clear() {

        idToProduct.clear();
    }
}
