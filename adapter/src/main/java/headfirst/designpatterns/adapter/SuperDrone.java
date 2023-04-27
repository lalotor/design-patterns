package headfirst.designpatterns.adapter;

public class SuperDrone implements Drone {

  @Override
  public String beep() {
    return getClass().getName() + " beep()";
  }

  @Override
  public String spinRotors() {
    return getClass().getName() + " spinRotors()";
  }

  @Override
  public String takeOff() {
    return getClass().getName() + " takeOff()";
  }
}
