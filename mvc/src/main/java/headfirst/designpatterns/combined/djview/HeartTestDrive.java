package headfirst.designpatterns.combined.djview;

public class HeartTestDrive {

  public static void main(String[] args) {
    HeartModelInterface model = new HeartModel();
    new HeartController(model);
  }
}
