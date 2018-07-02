package app;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class Checker {

  private static final String GNIB_NUMBER = "xxxx";
  private static final String GNIB_EXP_YEAR = "xx";
  private static final String GNIB_EXP_MONTH = "Sep";
  private static final String GNIB_EXP_DAY = "xx";
  private static final String FIRSTNAME = "xx";
  private static final String LASTNAME = "xx";
  private static final String BDAY_YEAR = "xx";
  private static final String BDAY_MONTH = "Jun";
  private static final String BDAY_DAY = "xx";
  private static final String EMAIL = "xiaoxue@xx.com";
  private static final String PASSPORT_NUM = "xx";

  private static WebDriver driver = new FirefoxDriver();

  Checker() {
    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
  }

   void fillInfo() throws InterruptedException {

    driver.get(
        "https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/AppSelect?OpenForm");

    Select category = new Select(driver.findElement(By.xpath("//select[ @id='Category']")));
    category.selectByValue("Work");

    Select subCategory = new Select(driver.findElement(By.xpath("//select[ @id='SubCategory']")));
    subCategory.selectByValue("Work Permit Holder");

    Select haveGNIB = new Select(driver.findElement(By.xpath("//select[ @id='ConfirmGNIB']")));
    haveGNIB.selectByValue("Renewal");

    WebElement gnibNumber = driver.findElement(By.xpath("//input[@id='GNIBNo']"));
    gnibNumber.clear();
    gnibNumber.sendKeys(GNIB_NUMBER);

    WebElement expiredate = driver.findElement(By.xpath("//input[@id='GNIBExDT']")); // date input
    expiredate.click();

    // date picker
    WebElement yearPickerDiv =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, "
                    + "'datepicker') and contains(@class, 'datepicker-orient-top')"
                    + "]/div[@class='datepicker-years']/table/tbody/tr/td/span[.='"
                    + GNIB_EXP_YEAR
                    + "']"));
    System.out.println(yearPickerDiv.getText() + " " + yearPickerDiv.getTagName());

    yearPickerDiv.click();
    WebElement monthPickerDiv =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, "
                    + "'datepicker') and contains(@class, 'datepicker-orient-top')"
                    + "]/div[@class='datepicker-months']/table/tbody/tr/td/span[.='"
                    + GNIB_EXP_MONTH
                    + "']"));
    System.out.println(monthPickerDiv.getText() + " " + monthPickerDiv.getTagName());
    monthPickerDiv.click();

    WebElement dayPickerDiv =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, "
                    + "'datepicker') and contains(@class, 'datepicker-orient-top')"
                    + "]/div[@class='datepicker-days']/table/tbody//td[.='"
                    + GNIB_EXP_DAY
                    + "']"));
    System.out.println(dayPickerDiv.getText() + " " + dayPickerDiv.getTagName());
    dayPickerDiv.click();

    WebElement checkbox =
        driver.findElement(By.xpath("//input[@id='UsrDeclaration']")); // date input
    checkbox.click();

    WebElement nameinput1 = driver.findElement(By.xpath("//input[@id='GivenName']")); // date input
    nameinput1.sendKeys(FIRSTNAME);

    WebElement nameinput2 = driver.findElement(By.xpath("//input[@id='SurName']")); // date input
    nameinput2.sendKeys(LASTNAME);

    WebElement birthdayInput = driver.findElement(By.xpath("//input[@id='DOB']")); // date input
    birthdayInput.click();

    WebElement move =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-years']/table/thead/tr/th[.='«']")); // date input
    move.click();
    move.click();
    move.click();

    yearPickerDiv =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, 'datepicker') and "
                    + "contains(@class, 'datepicker-orient-top')"
                    + "]/div[@class='datepicker-years']/table/tbody/tr/td/span[.='"
                    + BDAY_YEAR
                    + "']"));
    System.out.println(yearPickerDiv.getText() + " " + yearPickerDiv.getTagName());

    yearPickerDiv.click();
    monthPickerDiv =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, 'datepicker') and "
                    + "contains(@class, 'datepicker-orient-top')"
                    + "]/div[@class='datepicker-months']/table/tbody/tr/td/span[.='"
                    + BDAY_MONTH
                    + "']"));
    System.out.println(monthPickerDiv.getText() + " " + monthPickerDiv.getTagName());

    monthPickerDiv.click();
    dayPickerDiv =
        driver.findElement(
            By.xpath(
                "//div[contains(@class, 'datepicker') and "
                    + "contains(@class, 'datepicker-orient-top')"
                    + "]/div[@class='datepicker-days']/table/tbody//td[.='"
                    + BDAY_DAY
                    + "']"));
    System.out.println(dayPickerDiv.getText() + " " + dayPickerDiv.getTagName());

    dayPickerDiv.click();

    Select nationality = new Select(driver.findElement(By.xpath("//select[ @id='Nationality']")));
    nationality.selectByIndex(40);

    WebElement email1 = driver.findElement(By.xpath("//input[@id='Email']")); // date input
    email1.sendKeys(EMAIL);

    WebElement email2 = driver.findElement(By.xpath("//input[@id='EmailConfirm']")); // date input
    email2.sendKeys(EMAIL);

    Select family = new Select(driver.findElement(By.xpath("//select[ @id='FamAppYN']")));
    family.selectByIndex(2);

    Select passport = new Select(driver.findElement(By.xpath("//select[ @id='PPNoYN']")));
    passport.selectByIndex(1);
    Thread.sleep(2000);

    WebElement passportNumber = driver.findElement(By.xpath("//input[@id='PPNo']"));
    passportNumber.sendKeys(PASSPORT_NUM);
  }

   void searchAppointment() throws InterruptedException {
    WebElement search = driver.findElement(By.xpath("//button[@id='btLook4App']"));
    search.click();

    Select selectAppointmentsBy =
        new Select(driver.findElement(By.xpath("//select[ @id='AppSelectChoice']")));
    selectAppointmentsBy.selectByIndex(2);

    WebElement search2 = driver.findElement(By.xpath("//button[@id='btSrch4Apps']"));
    search2.click();
    Thread.sleep(2000);
  }

   void emailResult() throws EmailException {

    Date date = new Date();
    List<WebElement> dates =
        driver.findElements(By.xpath("//div[@id='dvAppOptions']/table/tbody/tr/td"));
    StringBuilder content = new StringBuilder();
    content.append("Hi:<br>");

    if (dates.size() == 2) {
      if (dates.get(1).getText().contains("No appointment")) {
        content.append("No appointment <br>");
      }
    } else {
      dates = driver.findElements(By.xpath("//div[@id='dvAppOptions']//table/tbody/tr/td"));
      for (WebElement a : dates) {
        content.append(a.getText()).append("<br>");
      }
      content.append(
          "Cancle Link: "
              + "<a>https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb"
              + ".nsf/AppCancel?OpenForm</a> <br> refrence example: EXTW-AQ3LJT691"
              + "<br>");
    }
    content.append("<br>GNIB Checker: ").append(date.toString()).append("<br>");

    EmailUtil.sendHTMLEmail(content.toString());
  }

  void quitDriver() {
    driver.quit();
  }
}
