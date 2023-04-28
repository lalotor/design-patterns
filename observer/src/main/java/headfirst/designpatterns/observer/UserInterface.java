package headfirst.designpatterns.observer;

public class UserInterface implements Observer {

  private final Subject subject;
  private String message;

  public UserInterface(Subject subject) {
    this.subject = subject;
    this.subject.registerObserver(this);
  }

  public void display() {
    System.out.println(getClass().getName() + " display() -> New weather update: " + message);
  }

  @Override
  public void update(float temperature, float windSpeed, float pressure) {
    message = "Temperature = " + temperature + " , wind speed = " + windSpeed + " , pressure = " + pressure;
    display();
  }

  public String getMessage() {
    return message;
  }
}
