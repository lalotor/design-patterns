package headfirst.designpatterns.combined.djview;

import static headfirst.designpatterns.combined.djview.Util.METHOD_NOT_IMPLEMENTED;

public class HeartController implements ControllerInterface {
  private HeartModelInterface model;
  private DJView view;

  public HeartController(HeartModelInterface model) {
    this.model = model;
    view = new DJView(new HeartAdapter(this.model), this);
    view.createView();
    view.createControls();
    view.disableStopMenuItem();
    view.enableStartMenuItem();
  }

  @Override
  public void start() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void stop() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void increaseBPM() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void decreaseBPM() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void setBPM(int bpm) {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }
}
