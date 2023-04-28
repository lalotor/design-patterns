package headfirst.designpatterns.decorator;

public class ThickCrustPizza extends Pizza {

  public ThickCrustPizza() {
    description = "Thick Crust Pizza";
  }

  @Override
  public double cost() {
    return 3.99;
  }
}
