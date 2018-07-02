package app;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

public class CheckerTest {

  @Test
  public void test() throws InterruptedException, EmailException {
    Checker check = new Checker();
    check.fillInfo();
    check.searchAppointment();
    check.emailResult();
    check.quitDriver();
  }
}
