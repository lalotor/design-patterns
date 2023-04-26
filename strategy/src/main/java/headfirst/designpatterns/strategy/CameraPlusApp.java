package headfirst.designpatterns.strategy;

public class CameraPlusApp extends PhoneCameraApp {

  @Override
  public String edit() {
    return getClass().getName() + " edit()";
  }

}
