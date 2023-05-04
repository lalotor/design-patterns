package headfirst.designpatterns.factory;

public class MountainCalendar extends Calendar {

  @Override
  public void createCalendar() {
    zone = ZoneFactory.createZone(USZones.MOUNTAIN);
    setUpCalendar();
  }
}
