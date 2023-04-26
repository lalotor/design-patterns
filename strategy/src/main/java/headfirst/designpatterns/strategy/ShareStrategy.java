package headfirst.designpatterns.strategy;

public interface ShareStrategy {

  default String share() {
    return getClass().getName() + " share()";
  }
}
