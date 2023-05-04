package headfirst.designpatterns.factory;

public class EasternCalendar extends Calendar {

  @Override
  public void createCalendar() {
    zone = ZoneFactory.createZone(USZones.EASTERN);
    setUpCalendar();
  }
}
