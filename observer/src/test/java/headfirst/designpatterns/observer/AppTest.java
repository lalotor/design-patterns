package headfirst.designpatterns.observer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void givenWeatherStation_whenCallMethods_thenExpectedResults() {
    //given - precondition or setup
    WeatherStation weatherStation = new WeatherStation();
    //when - action or the behaviour that we are going to test

    //then - verify the output
    assertThat(weatherStation.temperature()).isEqualTo(WeatherStation.class.getName() + " temperature()");
    assertThat(weatherStation.windSpeed()).isEqualTo(WeatherStation.class.getName() + " windSpeed()");
    assertThat(weatherStation.pressure()).isEqualTo(WeatherStation.class.getName() + " pressure()");
  }

  @Test
  void givenWeatherStation_whenDisplay_thenExpectedResult() {
    //given - precondition or setup
    UserInterface userInterface = new UserInterface();
    //when - action or the behaviour that we are going to test

    //then - verify the output
    assertThat(userInterface.display()).isEqualTo(UserInterface.class.getName() + " display()");
  }

  @Test
  void givenLogger_whenLog_thenExpectedResult() {
    //given - precondition or setup
    Logger logger = new Logger();
    //when - action or the behaviour that we are going to test

    //then - verify the output
    assertThat(logger.log()).isEqualTo(Logger.class.getName() + " log()");
  }

  @Test
  void givenAlertSystem_whenAlert_thenExpectedResult() {
    //given - precondition or setup
    AlertSystem alertSystem = new AlertSystem();
    //when - action or the behaviour that we are going to test

    //then - verify the output
    assertThat(alertSystem.alert()).isEqualTo(AlertSystem.class.getName() + " alert()");
  }

}
