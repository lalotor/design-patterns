package headfirst.designpatterns.combined.djview;

import static headfirst.designpatterns.combined.djview.Util.METHOD_NOT_IMPLEMENTED;

public class HeartAdapter implements BeatModelInterface {

  private final HeartModelInterface heart;

  public HeartAdapter(HeartModelInterface heart) {
    this.heart = heart;
  }

  @Override
  public void initialize() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void on() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void off() {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public void setBPM(int bpm) {
    throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
  }

  @Override
  public int getBPM() {
    return heart.getHeartRate();
  }

  @Override
  public void registerObserver(BeatObserver o) {
    heart.registerObserver(o);
  }

  @Override
  public void removeObserver(BeatObserver o) {
    heart.removeObserver(o);
  }

  @Override
  public void registerObserver(BPMObserver o) {
    heart.registerObserver(o);
  }

  @Override
  public void removeObserver(BPMObserver o) {
    heart.removeObserver(o);
  }
}
