package headfirst.designpatterns.factory;

import java.util.TimeZone;

public class PacificCalendar extends Calendar {

  @Override
  public void createCalendar() {
    zone = ZoneFactory.createZone(USZones.PACIFIC);
    setUpCalendar();
  }
}
