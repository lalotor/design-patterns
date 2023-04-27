package headfirst.designpatterns.adapter;

public class MallardDuck implements Duck {

  @Override
  public String quack() {
    return getClass().getName() + " quack()";
  }

  @Override
  public String fly() {
    return getClass().getName() + " fly()";
  }
}
