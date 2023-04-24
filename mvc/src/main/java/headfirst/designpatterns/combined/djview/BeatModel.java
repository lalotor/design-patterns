package headfirst.designpatterns.combined.djview;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;

public class BeatModel implements BeatModelInterface, Runnable {

  List<BeatObserver> beatObservers = new ArrayList<>();
  List<BPMObserver> bpmObservers = new ArrayList<>();
  int bpm = 90;
  Thread thread;
  boolean stop = false;
  Clip clip;

  @Override
  public void initialize() {
    try {
      File file = getFileFromResource("clap.wav");
      ByteArrayInputStream audioBytes = new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
      AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioBytes);
      AudioFormat format = inputStream.getFormat();
      /*
       * clip = AudioSystem.getClip();
       * clip.addLineListener(event -> {
       * if (LineEvent.Type.STOP.equals(event.getType())) {
       * clip.close();
       * }
       * });
       * clip.open(inputStream);
       */

    } catch (Exception e) {
      System.out.println("Error: Can't load clip");
      System.out.println(e);
      e.printStackTrace();
    }
  }

  @Override
  public void on() {
    bpm = 90;
    notifyBPMObservers();
    thread = new Thread(this);
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
    //clip.setFramePosition(0);
    //clip.start();
  }

  public void stopBeat() {
    //clip.setFramePosition(0);
    //clip.stop();
  }

  private File getFileFromResource(String fileName) throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    } else {
      return new File(resource.toURI());
    }

  }

}
