package headfirst.designpatterns.strategy;

public class BasicCameraApp extends PhoneCameraApp {

  public BasicCameraApp() {
    shareStrategy = new ShareTxt();
  }

  @Override
  public String edit() {
    return getClass().getName() + " edit()";
  }
}
