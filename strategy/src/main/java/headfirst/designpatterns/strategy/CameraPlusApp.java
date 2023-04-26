package headfirst.designpatterns.strategy;

public class CameraPlusApp extends PhoneCameraApp {

  public CameraPlusApp() {
    shareStrategy = new ShareEmail();
  }

  @Override
  public String edit() {
    return getClass().getName() + " edit()";
  }

}
