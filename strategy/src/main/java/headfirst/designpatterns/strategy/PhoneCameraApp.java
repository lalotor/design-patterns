package headfirst.designpatterns.strategy;

public abstract class PhoneCameraApp {

  private static final String CLASS_NAME = PhoneCameraApp.class.getName();
  public String take() {
    return CLASS_NAME + " [default] take()";
  }

  public String save() {
    return CLASS_NAME + " [default] save()";
  }

  public String share() {
    return CLASS_NAME + " [default] share()";
  }

  public abstract String edit();
}
