package headfirst.designpatterns.adapter;

public class DroneAdapter implements Duck {
  Drone drone;

  public DroneAdapter(Drone drone) {
    this.drone = drone;
  }

  @Override
  public String quack() {
    return drone.beep();
  }

  @Override
  public String fly() {
    return drone.spinRotors() + " - " + drone.takeOff();
  }
}
