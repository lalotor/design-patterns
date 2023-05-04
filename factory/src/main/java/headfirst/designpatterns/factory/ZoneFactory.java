package headfirst.designpatterns.factory;

public class ZoneFactory {

  private ZoneFactory() {
  }

  public static Zone createZone(USZones zoneType) {
    Zone zone = null;
    if (zoneType == USZones.EASTERN) {
      zone = new ZoneUSEastern();
    } else if (zoneType == USZones.CENTRAL) {
      zone = new ZoneUSCentral();
    } else if (zoneType == USZones.MOUNTAIN) {
      zone = new ZoneUSMountain();
    } else if (zoneType == USZones.PACIFIC) {
      zone = new ZoneUSPacific();
    }

    return zone;
  }
}
