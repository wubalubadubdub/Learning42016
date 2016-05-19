/**
 * Created by bearg on 5/14/2016.
 */
public class Fubar<T,U> extends Bar<T> {

    private T t1;
    private T t2;
    private U u;

    public Fubar(T t1, T t2, U u) {

        super(t1, t2);
        this.u = u;
        System.out.println("Fubar ctor called");
    }

    public U getU() {

        return u;
    }
}
