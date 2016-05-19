import java.math.BigDecimal;

/**
 * Created by bearg on 5/17/2016.
 */
public class RegularEmployee {

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static BigDecimal getBonusMultiplier() {
        return new BigDecimal(".02");
    }

    public BigDecimal calculateBonus() {
        return salary.multiply(getBonusMultiplier());
    }

    // presumably lots of other code...
}
