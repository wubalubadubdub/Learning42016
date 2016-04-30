import java.util.ArrayList;
import java.util.List;

/**
 * Created by bearg on 4/30/2016.
 */
public class NaiveProductLookupTable implements ProductLookupTable{

    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(final Product productToAdd) {

        for (Product product : products) {
            // check if product already in list
            if (product.getId() == productToAdd.getId()) {
                throw new IllegalArgumentException("Unable to add product. " +
                        "Duplicate id for " + productToAdd);
                // IllegalArgumentException is a runtime exception and thus,
                // unchecked. It shouldn't be caught. If it's thrown, there's
                // error in our program logic.
            }
        }
        products.add(productToAdd);
    }

    @Override
    public Product lookupById(final int id) {
        for(Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null; // if product with that ID doesn't exist
    }

    @Override
    public void clear() {
        products.clear();
    }
}
