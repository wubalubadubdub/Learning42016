/**
 * Created by bearg on 5/14/2016.
 */
public class Foo<T> {

    public Foo() {}

    public Foo(T t1, T t2) {

        System.out.println("Foo ctor called");
    } // since explicit ctor is given, no more default empty ctor
}
