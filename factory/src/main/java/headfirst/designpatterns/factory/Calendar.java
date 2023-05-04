package headfirst.designpatterns.factory;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public abstract class Calendar {
  private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
  protected Zone zone;
  protected java.util.Calendar internalCalendar;

  public String print() {
    sdf.setTimeZone(TimeZone.getTimeZone(zone.getDisplayName()));

    return sdf.format(internalCalendar.getTime());
  }

  public abstract void createCalendar();

  protected void setUpCalendar() {
    internalCalendar = java.util.Calendar.getInstance(TimeZone.getTimeZone(zone.getDisplayName()));
  }
}
