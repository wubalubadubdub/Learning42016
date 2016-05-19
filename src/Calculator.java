/**
 * Created by bearg on 5/11/2016.
 */
public class Calculator {

    private Calculator() {

        // suppress default ctor for noninstantiability using private ctor
        // below not required, but is insurance in case ctor accidentally
        // called within the class
        throw new AssertionError();
    }

    // we use varargs below. it creates an array with
    // the given args and passes the array to the method
    public static void add(int... numbers) {

        System.out.println(numbers.length);
        int sum = 0;
        for (int num : numbers) {

            sum += num;
        }

        System.out.println("Sum is " + sum);

    }

}
