import java.math.BigDecimal;

/**
 * Created by bearg on 5/9/2016.
 */
public class Test {

    public static void main(String[] args) {


    }

    public static void staticDemo() {
        SpecialEmployee tom = new SpecialEmployee();
        tom.setSalary(new BigDecimal("45230.00"));
        int comparisonResult = tom.calculateBonus().compareTo(new BigDecimal("45230.00")
        .multiply(new BigDecimal(".02"))) ;
        System.out.println(comparisonResult); // 0
        // the static getBonusMultiplier() method called is the one in
        // RegularEmployee, so he'll get 2% bonus, even though we might
        // expect a 3% bonus from the code. that's because there's no
        // overriding of static methods in java.

        System.out.println(tom.getBonusMultiplier()); // 0.03

        RegularEmployee dan = new SpecialEmployee();

        // if class B extends A, and both classes have a static method
        // called someStatic(), then bInstance.someStatic() uses the
        // declared type of bInstance, which is RegularEmployee, in this case,
        // and invokes A.someStatic() even though B.someStatic() exists.
        System.out.println(dan.getBonusMultiplier()); // 0.02

        // The compiler can't examine the instance to see what it is, since
        // the instance doesn't exist until runtime. The compiler can only
        // invoke the static method based on the declared type, which could
        // be the actual type or any of its superclasses. Java does not choose
        // a static method based on the runtime type like it does for instance methods
    }


    @SuppressWarnings({"UnnecessaryBoxing", "unused", "UnnecessaryLocalVariable"})
    public static void conversions() {

        byte bitey = 100;
        int inty = bitey; // no cast required. java does implicit primitive widening conversion
        long longy = 100000; // "  "

        int j = 128;
        byte b2 = (byte) j; // all bytes are ints but not vice versa. java won't do implicit primitive narrowing conversion
        System.out.println(b2); // -128, because the value is being wrapped after 127.
        // so it's -128, -127, ... , 126, 127, -128, -127 ...

        // with reference types...
        // Byte b = new Byte(10); won't compile -- primitive narrowing conversion int to byte
        Byte b = new Byte((byte) 10); // can promise compiler the int is also a byte, then byte is autoboxed to Byte

        Long longer = new Long(10); // primitive widening int to long, and the ctor boxes a long to Long
        // Long longest = 10; won't compile -- widening followed by boxing without using ctor


    }
}
