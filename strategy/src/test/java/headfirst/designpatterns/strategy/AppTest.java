package headfirst.designpatterns.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void givenPhoneCameraApp_whenTake_thenExpectedResult() {
    //given - precondition or setup
    PhoneCameraApp app = new BasicCameraApp();
    //when - action or the behaviour that we are going to test
    String result = app.take();
    //then - verify the output
    assertThat(result).isEqualTo(PhoneCameraApp.class.getName() + " [default] take()");
  }

  @Test
  void givenPhoneCameraApp_whenSave_thenExpectedResult() {
    //given - precondition or setup
    PhoneCameraApp app = new CameraPlusApp();
    //when - action or the behaviour that we are going to test
    String result = app.save();
    //then - verify the output
    assertThat(result).isEqualTo(PhoneCameraApp.class.getName() + " [default] save()");
  }

  @Test
  void givenPhoneCameraApp_whenShare_thenExpectedResult() {
    //given - precondition or setup
    PhoneCameraApp app = new BasicCameraApp();
    //when - action or the behaviour that we are going to test
    String result = app.share();
    //then - verify the output
    assertThat(result).isEqualTo(PhoneCameraApp.class.getName() + " [default] share()");
  }

  @Test
  void givenBasicCameraApp_whenEdit_thenExpectedResult() {
    //given - precondition or setup
    PhoneCameraApp app = new BasicCameraApp();
    //when - action or the behaviour that we are going to test
    String result = app.edit();
    //then - verify the output
    assertThat(result).isEqualTo(app.getClass().getName() + " edit()");
  }

  @Test
  void givenCameraPlusApp_whenEdit_thenExpectedResult() {
    //given - precondition or setup
    PhoneCameraApp app = new CameraPlusApp();
    //when - action or the behaviour that we are going to test
    String result = app.edit();
    //then - verify the output
    assertThat(result).isEqualTo(app.getClass().getName() + " edit()");
  }
}
