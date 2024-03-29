package headfirst.designpatterns.combined.djview;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Clip;

public class BeatModel implements BeatModelInterface, Runnable {

  private final List<BeatObserver> beatObservers = new ArrayList<>();
  private final List<BPMObserver> bpmObservers = new ArrayList<>();
  private int bpm = 90;
  private boolean stop = false;
  private Clip clip;

  @Override
  public void initialize() {
    Util util = new Util();
    clip = util.loadSoundClip("clap.wav");
  }

  @Override
  public void on() {
    bpm = 90;
    notifyBPMObservers();
    Thread thread = new Thread(this);
    stop = false;
    thread.start();
  }

  @Override
  public void off() {
    stopBeat();
    stop = true;
  }

  public void run() {
    while (!stop) {
      playBeat();
      notifyBeatObservers();
      try {
        Thread.sleep(60000 / getBPM());
      } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  @Override
  public void setBPM(int bpm) {
    this.bpm = bpm;
    notifyBPMObservers();
  }

  @Override
  public int getBPM() {
    return bpm;
  }

  @Override
  public void registerObserver(BeatObserver o) {
    beatObservers.add(o);
  }

  public void notifyBeatObservers() {
    beatObservers.forEach(BeatObserver::updateBeat);
  }

  @Override
  public void removeObserver(BeatObserver o) {
    beatObservers.remove(o);
  }

  @Override
  public void registerObserver(BPMObserver o) {
    bpmObservers.add(o);
  }

  public void notifyBPMObservers() {
    bpmObservers.forEach(BPMObserver::updateBPM);
  }

  @Override
  public void removeObserver(BPMObserver o) {
    bpmObservers.remove(o);
  }

  public void playBeat() {
    clip.setFramePosition(0);
    clip.start();
  }

  public void stopBeat() {
    clip.setFramePosition(0);
    clip.close();
  }

}
