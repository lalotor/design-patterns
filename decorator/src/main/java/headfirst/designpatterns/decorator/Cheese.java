package headfirst.designpatterns.decorator;

public class Cheese extends ToppingDecorator {

  private Pizza pizza;

  public Cheese(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public double cost() {
    return pizza.cost() + 1.99;
  }

  @Override
  public String getDescription() {
    return pizza.getDescription() +  ", Cheese";
  }
}
