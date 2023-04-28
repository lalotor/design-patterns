package headfirst.designpatterns.decorator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
  private Pizza thinPizza;
  private Pizza thickPizza;

  @BeforeEach
  public void setUp() {
    thinPizza = new ThinCrustPizza();
    thickPizza = new ThickCrustPizza();
  }

  @Test
  void givenOneDecorator_whenDescriptionAndCost_thenExpectedResult() {
    //given - precondition or setup
    thinPizza = new Cheese(thinPizza);
    //when - action or the behaviour that we are going to test
    String description = thinPizza.getDescription();
    double cost = thinPizza.cost();
    //then - verify the output
    assertThat(description).isEqualTo("Thin Crust Pizza, Cheese");
    assertThat(cost).isEqualTo(4.98);
  }

  @Test
  void givenTwoDecorator_whenDescriptionAndCost_thenExpectedResult() {
    //given - precondition or setup
    thickPizza = new Cheese(thickPizza);
    thickPizza = new Peppers(thickPizza);
    //when - action or the behaviour that we are going to test
    String description = thickPizza.getDescription();
    double cost = thickPizza.cost();
    //then - verify the output
    assertThat(description).isEqualTo("Thick Crust Pizza, Cheese, Peppers");
    assertThat(cost).isCloseTo(7.27, Percentage.withPercentage(0.1));
  }

  @Test
  void givenThreeDecorator_whenDescriptionAndCost_thenExpectedResult() {
    //given - precondition or setup
    thinPizza = new Cheese(thinPizza);
    thinPizza = new Olives(thinPizza);
    thinPizza = new Peppers(thinPizza);
    //when - action or the behaviour that we are going to test
    String description = thinPizza.getDescription();
    double cost = thinPizza.cost();
    //then - verify the output
    assertThat(description).isEqualTo("Thin Crust Pizza, Cheese, Olives, Peppers");
    assertThat(cost).isCloseTo(7.26, Percentage.withPercentage(0.1));
  }

  @Test
  void givenRepeatedDecorator_whenDescriptionAndCost_thenExpectedResult() {
    //given - precondition or setup
    thickPizza = new Cheese(thickPizza);
    thickPizza = new Cheese(thickPizza);
    thickPizza = new Peppers(thickPizza);
    //when - action or the behaviour that we are going to test
    String description = thickPizza.getDescription();
    double cost = thickPizza.cost();
    //then - verify the output
    assertThat(description).isEqualTo("Thick Crust Pizza, Cheese, Cheese, Peppers");
    assertThat(cost).isCloseTo(9.26, Percentage.withPercentage(0.1));
  }

}
