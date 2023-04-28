package headfirst.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Logger implements Observer {
  private final Subject subject;
  private final List<String> entries;

  public Logger(Subject subject) {
    this.subject = subject;
    this.subject.registerObserver(this);
    entries = new ArrayList<>();
  }

  public void log() {
    System.out.println(getClass().getName() + " log() -> Log entries: " + entries);
  }

  public void addEntry(String entry) {
    entries.add(entry);
  }

  public String getEntriesAsString() {
    return entries.stream().collect(Collectors.joining(" | "));
  }

  public String getEntry(int index) {
    return entries.get(index);
  }

  @Override
  public void update(float temperature, float windSpeed, float pressure) {
    addEntry("[Temperature]: " + temperature);
    addEntry("[WindSpeed]: " + windSpeed);
    addEntry("[Pressure]: " + pressure);
    log();
  }

}
