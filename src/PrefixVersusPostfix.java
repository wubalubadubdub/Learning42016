/**
 * Created by bearg on 5/11/2016.
 */
public class PrefixVersusPostfix {

    private PrefixVersusPostfix() {

        throw new AssertionError("Bad! Bad programmer!");
    }

    /**
     * The prefix does the increment/decrement first and then
     * returns the value after increment/decrement
     */

    public static void demonstratePrefix() {

        int count = 1;
        System.out.println("Start value = " + count);
        System.out.println("Prefix increment = " + ++count); // 2

        count = 1;
        System.out.println("Start value = " + count);
        System.out.println("Prefix decrement = " + --count); // 0

    }

    /**
     * Postfix first returns the current value and then does the
     * increment/decrement
     */

    public static void demonstratePostfix() {

        int count = 1;
        System.out.println("Start value = " + count);
        System.out.println("Postfix increment = " + count++); // 1

        count = 1;
        System.out.println("Start value = " + count);
        System.out.println("Postfix decrement = " + count--); // 1
    }
}
