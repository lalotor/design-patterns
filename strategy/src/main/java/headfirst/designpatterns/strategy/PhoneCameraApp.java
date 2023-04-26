package headfirst.designpatterns.strategy;

public abstract class PhoneCameraApp {

  private static final String CLASS_NAME = PhoneCameraApp.class.getName();

  protected ShareStrategy shareStrategy;

  public String take() {
    return CLASS_NAME + " [default] take()";
  }

  public String save() {
    return CLASS_NAME + " [default] save()";
  }

  public String performShare() {
    return shareStrategy.share();
  }

  public abstract String edit();

  public void setShareStrategy(ShareStrategy shareStrategy) {
    this.shareStrategy = shareStrategy;
  }
}
