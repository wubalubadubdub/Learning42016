/**
 * Created by bearg on 4/30/2016.
 */
public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();
}
