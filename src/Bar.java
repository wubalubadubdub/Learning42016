/**
 * Created by bearg on 5/14/2016.
 */
public class Bar<T> extends Foo<T> {

    public Bar(T t1, T t2) {

        super(t1, t2);
        System.out.println("Bar ctor called");
    }

}
