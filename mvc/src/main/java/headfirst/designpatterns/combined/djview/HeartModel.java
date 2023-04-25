package headfirst.designpatterns.combined.djview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.Clip;

public class HeartModel implements HeartModelInterface, Runnable {

  private final List<BeatObserver> beatObservers = new ArrayList<>();
  private final List<BPMObserver> bpmObservers = new ArrayList<>();
  private int time = 1000;
  private final Random random = new Random(System.currentTimeMillis());
  private final Clip clip;

  public HeartModel() {
    Util util = new Util();
    clip = util.loadSoundClip("clap.wav");
    Thread thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    int lastRate = -1;
    for (;;) {
      int change = random.nextInt(10);
      if (random.nextInt(2) == 0) {
        change = 0 - change;
      }
      int rate = 60000 / (time + change);
      if (rate < 120 && rate > 50) {
        time += change;
        playBeat();
        notifyBeatObservers();
        if (rate != lastRate) {
          lastRate = rate;
          notifyBPMObservers();
        }
      }
      try {
        Thread.sleep(time);
      } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  @Override
  public int getHeartRate() {
    return 60000 / time;
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

  private void playBeat() {
    clip.setFramePosition(0);
    clip.start();
  }

}
