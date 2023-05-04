package headfirst.designpatterns.factory;

public class CentralCalendar extends Calendar {

  @Override
  public void createCalendar() {
    zone = ZoneFactory.createZone(USZones.CENTRAL);
    setUpCalendar();
  }
}
