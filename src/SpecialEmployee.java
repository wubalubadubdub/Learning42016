import java.math.BigDecimal;

/**
 * Created by bearg on 5/17/2016.
 */
public class SpecialEmployee extends RegularEmployee {

    public static BigDecimal getBonusMultiplier() {
        return new BigDecimal(".03");
    }

    // method below causes bonus to be calculated using the
    // getBonusMultiplier() method in this class
    /*@Override
    public BigDecimal calculateBonus() {
        return this.getSalary().multiply(getBonusMultiplier());
    }*/
}
