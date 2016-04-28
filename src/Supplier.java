import java.util.ArrayList;
import java.util.List;

/**
 * Created by bearg on 4/25/2016.
 */
public class Supplier {

    private String name;
    private List<Product> products = new ArrayList<>();

    public Supplier(String name) {
        this.name = name;
    }

    public List<Product> products() {
        return products;
    }
}
