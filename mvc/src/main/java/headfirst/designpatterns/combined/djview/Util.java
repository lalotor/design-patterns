package headfirst.designpatterns.combined.djview;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Util {

  public static final String METHOD_NOT_IMPLEMENTED = "Method not implemented";

  public File getFileFromResource(String fileName) throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("File not found! " + fileName);
    } else {
      return new File(resource.toURI());
    }
  }

  public Clip loadSoundClip(String wavFileName) {
    Clip clip = null;
    try {
      File file = getFileFromResource(wavFileName);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
      AudioFormat audioFormat = audioStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
      clip = (Clip) AudioSystem.getLine(info);
      clip.open(audioStream);
    } catch (Exception e) {
      System.out.println("Error: Can't load clip");
      e.printStackTrace();
    }

    return clip;
  }
}
