package app;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Checker {
	
	public static void main(String args[]){
		check();
	}

	public static void check() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/AppSelect?OpenForm");

		Select category = new Select(driver.findElement(By.xpath("//select[ @id='Category']")));
		category.selectByValue("Work");

		Select subCategory = new Select(driver.findElement(By.xpath("//select[ @id='SubCategory']")));
		subCategory.selectByValue("Work Permit Holder");

		Select haveGNIB = new Select(driver.findElement(By.xpath("//select[ @id='ConfirmGNIB']")));
		haveGNIB.selectByValue("Renewal");

		WebElement GNIBNumber = driver.findElement(By.xpath("//input[@id='GNIBNo']"));
		GNIBNumber.clear();
		GNIBNumber.sendKeys("111111");

		WebElement expiredate = driver.findElement(By.xpath("//input[@id='GNIBExDT']")); //date input
		expiredate.click();

		//date picker
		WebElement yearPickerDiv = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-years']/table/tbody/tr/td/span[.='2017']"));
		System.out.println(yearPickerDiv.getText() + " " + yearPickerDiv.getTagName());;
		yearPickerDiv.click();
		WebElement MonthPickerDiv = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-months']/table/tbody/tr/td/span[.='Sep']"));
		System.out.println(MonthPickerDiv.getText() + " " + MonthPickerDiv.getTagName());;
		MonthPickerDiv.click();
		WebElement dayPickerDiv = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-days']/table/tbody//td[.='30']"));
		System.out.println(dayPickerDiv.getText() + " " + dayPickerDiv.getTagName());;
		dayPickerDiv.click();

		WebElement checkbox = driver.findElement(By.xpath("//input[@id='UsrDeclaration']")); //date input
		checkbox.click();

		WebElement nameinput1 = driver.findElement(By.xpath("//input[@id='GivenName']")); //date input
		nameinput1.sendKeys("XIAOXUE");

		WebElement nameinput2 = driver.findElement(By.xpath("//input[@id='SurName']")); //date input
		nameinput2.sendKeys("CHEN");

		WebElement birthdayInput = driver.findElement(By.xpath("//input[@id='DOB']")); //date input
		birthdayInput.click();

		WebElement move = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-years']/table/thead/tr/th[.='«']")); //date input
		move.click();
		move.click();
		move.click();

		yearPickerDiv = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-years']/table/tbody/tr/td/span[.='1987']"));
		System.out.println(yearPickerDiv.getText() + " " + yearPickerDiv.getTagName());;
		yearPickerDiv.click();
		MonthPickerDiv = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-months']/table/tbody/tr/td/span[.='Jun']"));
		System.out.println(MonthPickerDiv.getText() + " " + MonthPickerDiv.getTagName());;
		MonthPickerDiv.click();
		dayPickerDiv = driver.findElement(By.xpath("//div[contains(@class, 'datepicker') and contains(@class, 'datepicker-orient-top')]/div[@class='datepicker-days']/table/tbody//td[.='25']"));
		System.out.println(dayPickerDiv.getText() + " " + dayPickerDiv.getTagName());;
		dayPickerDiv.click();

		Select nationality = new Select(driver.findElement(By.xpath("//select[ @id='Nationality']")));
		nationality.selectByIndex(40);

		WebElement email1 = driver.findElement(By.xpath("//input[@id='Email']")); //date input
		email1.sendKeys("chenx6@tcd.ie");

		WebElement email2 = driver.findElement(By.xpath("//input[@id='EmailConfirm']")); //date input
		email2.sendKeys("chenx6@tcd.ie");

		Select family = new Select(driver.findElement(By.xpath("//select[ @id='FamAppYN']")));
		family.selectByIndex(2);

		Select passport = new Select(driver.findElement(By.xpath("//select[ @id='PPNoYN']")));
		passport.selectByIndex(1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement passportNumber = driver.findElement(By.xpath("//input[@id='PPNo']"));
		passportNumber.sendKeys("xxxxxxxx");

		WebElement search = driver.findElement(By.xpath("//button[@id='btLook4App']"));
		search.click();

		Select selectAppointmentsBy = new Select(driver.findElement(By.xpath("//select[ @id='AppSelectChoice']")));
		selectAppointmentsBy.selectByIndex(2);

		WebElement search2 = driver.findElement(By.xpath("//button[@id='btSrch4Apps']"));
		search2.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='dvAppOptions']/table/tbody/tr/td"));
		if (dates.size() == 2) {
			if (dates.get(1).getText().contains("No appointment")) { //No appointment(s) are currently available
				System.out.println("nothing:"+date.toString());
			}
		} else {
			dates = driver.findElements(By.xpath("//div[@id='dvAppOptions']//table/tbody/tr/td"));
			String content = "\n";
			for (WebElement a : dates) {
				content += a.getText() + "\n";
			}
			content += ("\n" + date.toString() + "\n");
			content += ("Cancle Link: " + "<a>https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/AppCancel?OpenForm </a> EXTW-AQ3LJT691" + "\n");
			try {
				EmailUtil.sendHTMLEmail(content);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
