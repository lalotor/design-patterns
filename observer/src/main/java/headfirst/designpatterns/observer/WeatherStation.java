package headfirst.designpatterns.observer;

public class WeatherStation {
  public String temperature() {
    return getClass().getName() + " temperature()";
  }

  public String windSpeed() {
    return getClass().getName() + " windSpeed()";
  }

  public String pressure() {
    return getClass().getName() + " pressure()";
  }
}
