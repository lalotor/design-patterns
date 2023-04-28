package headfirst.designpatterns.observer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
  private WeatherStation weatherStation;
  private UserInterface userInterface;
  private Logger logger;
  private AlertSystem alertSystem;
  private final float temperature = 8.7f;
  private final float windSpeed = 10f;
  private final float pressure = 47.83f;

  @BeforeEach
  public void setUp() {
    weatherStation = new WeatherStation();
    userInterface = new UserInterface(weatherStation);
    logger = new Logger(weatherStation);
    alertSystem = new AlertSystem(weatherStation);
  }

  @Test
  void givenObservers_whenSetMeasurements_thenExpectedResult() {
    //given - precondition or setup
    //when - action or the behaviour that we are going to test
    weatherStation.setMeasurements(temperature, windSpeed, pressure);
    //then - verify the output
    assertThat(userInterface.getMessage()).isEqualTo("Temperature = 8.7 , wind speed = 10.0 , pressure = 47.83");
    assertThat(logger.getEntriesAsString()).isEqualTo("[Temperature]: 8.7 | [WindSpeed]: 10.0 | [Pressure]: 47.83");
    assertThat(logger.getEntry(1)).isEqualTo("[WindSpeed]: 10.0");
    assertThat(alertSystem.isTemperatureOutOfRange()).isFalse();
    assertThat(alertSystem.isWindSpeedOutOfRange()).isTrue();
    assertThat(alertSystem.isPressureOutOfRange()).isTrue();
  }

  @Test
  void givenLogger_whenRemoveObserver_thenEmptyEntries() {
    //given - precondition or setup
    //when - action or the behaviour that we are going to test
    weatherStation.removeObserver(logger);
    weatherStation.setMeasurements(temperature, windSpeed, pressure);
    //then - verify the output
    assertThat(logger.getEntriesAsString()).isEmpty();
  }

}
