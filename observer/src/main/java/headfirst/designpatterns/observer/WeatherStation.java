package headfirst.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

  private final List<Observer> observers = new ArrayList<>();
  private float temperature;
  private float windSpeed;
  private float pressure;

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(o -> o.update(this.temperature, this.windSpeed, this.pressure));
  }

  public void setMeasurements(float temperature, float windSpeed, float pressure) {
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;

    notifyObservers();
  }

  public float getTemperature() {
    return temperature;
  }

  public float getWindSpeed() {
    return windSpeed;
  }

  public float getPressure() {
    return pressure;
  }
}
