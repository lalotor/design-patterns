package headfirst.designpatterns.observer;

public class AlertSystem implements Observer {

  private static final float MIN_TEMPERATURE = -5.0f;
  private static final float MAX_TEMPERATURE = 30.0f;
  private static final float MIN_WIND_SPEED = 0.0f;
  private static final float MAX_WIND_SPEED = 7.23f;
  private static final float MIN_PRESSURE = -15.7f;
  private static final float MAX_PRESSURE = 7.6f;
  private final Subject subject;
  private boolean temperatureOutOfRange;
  private boolean windSpeedOutOfRange;
  private boolean pressureOutOfRange;

  public AlertSystem(Subject subject) {
    this.subject = subject;
    this.subject.registerObserver(this);
  }

  public void alert() {
    System.out.println(getClass().getName() + " alert() -> isTemperatureOutOfRange? " + temperatureOutOfRange
        + " , isWindSpeedOutOfRange? " + windSpeedOutOfRange
        + " , isPressureOutOfRange? " + pressureOutOfRange);
  }

  @Override
  public void update(float temperature, float windSpeed, float pressure) {
    temperatureOutOfRange = temperature < MIN_TEMPERATURE || temperature > MAX_TEMPERATURE;
    windSpeedOutOfRange = windSpeed < MIN_WIND_SPEED || windSpeed > MAX_WIND_SPEED;
    pressureOutOfRange = pressure < MIN_PRESSURE || pressure > MAX_PRESSURE;
    alert();
  }

  public boolean isTemperatureOutOfRange() {
    return temperatureOutOfRange;
  }

  public boolean isWindSpeedOutOfRange() {
    return windSpeedOutOfRange;
  }

  public boolean isPressureOutOfRange() {
    return pressureOutOfRange;
  }
}