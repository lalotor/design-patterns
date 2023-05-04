package headfirst.designpatterns.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

  private SimpleDateFormat sdf;

  @BeforeEach
  public void setUp() {
    sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
  }

  @Test
  void givenEasternPacificCalendar_whenCreateCalendar_thenExpectedResult() {
    //given - precondition or setup
    Calendar calendar = new EasternCalendar();
    sdf.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
    //when - action or the behaviour that we are going to test
    calendar.createCalendar();
    //then - verify the output
    assertThat(calendar.print()).isEqualTo(sdf.format(new Date()));
  }

  @Test
  void givenCentralPacificCalendar_whenCreateCalendar_thenExpectedResult() {
    //given - precondition or setup
    Calendar calendar = new CentralCalendar();
    sdf.setTimeZone(TimeZone.getTimeZone("US/Central"));
    //when - action or the behaviour that we are going to test
    calendar.createCalendar();
    //then - verify the output
    assertThat(calendar.print()).isEqualTo(sdf.format(new Date()));
  }

  @Test
  void givenMountainPacificCalendar_whenCreateCalendar_thenExpectedResult() {
    //given - precondition or setup
    Calendar mountainCalendar = new MountainCalendar();
    sdf.setTimeZone(TimeZone.getTimeZone("US/Mountain"));
    //when - action or the behaviour that we are going to test
    mountainCalendar.createCalendar();
    //then - verify the output
    assertThat(mountainCalendar.print()).isEqualTo(sdf.format(new Date()));
  }

  @Test
  void givenPacificCalendar_whenCreateCalendar_thenExpectedResult() {
    //given - precondition or setup
    Calendar pacificCalendar = new PacificCalendar();
    sdf.setTimeZone(TimeZone.getTimeZone("US/Pacific"));
    //when - action or the behaviour that we are going to test
    pacificCalendar.createCalendar();
    //then - verify the output
    assertThat(pacificCalendar.print()).isEqualTo(sdf.format(new Date()));
  }



}
