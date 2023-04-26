package headfirst.designpatterns.strategy;

public class BasicCameraApp extends PhoneCameraApp {

  @Override
  public String edit() {
    return getClass().getName() + " edit()";
  }
}
