package headfirst.designpatterns.decorator;

public class Peppers extends ToppingDecorator {

  private Pizza pizza;

  public Peppers(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public double cost() {
    return pizza.cost() + 1.29;
  }

  @Override
  public String getDescription() {
    return pizza.getDescription() +  ", Peppers";
  }
}
