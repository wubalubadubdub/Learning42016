/**
 * Created by bearg on 5/9/2016.
 */
public interface Coffee {

    double getCost();
    String getIngredients();

}

class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Just coffee";
    }
}

abstract class CondimentDecorator implements Coffee {

    private final Coffee decoratedCoffee;

    public CondimentDecorator(Coffee c) {

        this.decoratedCoffee = c;
    }

    @Override
    public String getIngredients() {

        return decoratedCoffee.getIngredients();
    }

    @Override
    public double getCost() {

        return decoratedCoffee.getCost();
    }
}

class WithMilk extends CondimentDecorator {

    public WithMilk(Coffee c) {

        super(c);
    }

    @Override
    public String getIngredients() {

        return super.getIngredients() + ", Milk";
    }

    @Override
    public double getCost() {

        return super.getCost() + 0.5; // milk costs addt'l 50 cents
    }
}


class WithSugar extends CondimentDecorator {

    public WithSugar(Coffee c) {

        super(c);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Sugar";
    }
}


