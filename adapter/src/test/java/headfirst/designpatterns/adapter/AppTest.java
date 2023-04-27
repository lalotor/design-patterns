package headfirst.designpatterns.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void givenSuperDrone_whenBeep_thenExpectedResult() {
    //given - precondition or setup
    Drone app = new SuperDrone();
    //when - action or the behaviour that we are going to test
    String result = app.beep();
    //then - verify the output
    assertThat(result).isEqualTo(SuperDrone.class.getName() + " beep()");
  }

  @Test
  void givenSuperDrone_whenSpinRotors_thenExpectedResult() {
    //given - precondition or setup
    Drone app = new SuperDrone();
    //when - action or the behaviour that we are going to test
    String result = app.spinRotors();
    //then - verify the output
    assertThat(result).isEqualTo(SuperDrone.class.getName() + " spinRotors()");
  }

  @Test
  void givenSuperDrone_whenTakeOff_thenExpectedResult() {
    //given - precondition or setup
    Drone app = new SuperDrone();
    //when - action or the behaviour that we are going to test
    String result = app.takeOff();
    //then - verify the output
    assertThat(result).isEqualTo(SuperDrone.class.getName() + " takeOff()");
  }

  @Test
  void givenMallardDuck_whenQuack_thenExpectedResult() {
    //given - precondition or setup
    Duck app = new MallardDuck();
    //when - action or the behaviour that we are going to test
    String result = app.quack();
    //then - verify the output
    assertThat(result).isEqualTo(MallardDuck.class.getName() + " quack()");
  }

  @Test
  void givenMallardDuck_whenFly_thenExpectedResult() {
    //given - precondition or setup
    Duck app = new MallardDuck();
    //when - action or the behaviour that we are going to test
    String result = app.fly();
    //then - verify the output
    assertThat(result).isEqualTo(MallardDuck.class.getName() + " fly()");
  }

}
