package headfirst.designpatterns.decorator;

public class ThinCrustPizza extends Pizza {

  public ThinCrustPizza() {
    description = "Thin Crust Pizza";
  }

  @Override
  public double cost() {
    return 2.99;
  }
}
