package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import pom.pom;

public class MakeAppointment extends base {

	pom pom;

	public MakeAppointment() {
		super();
	}

	@BeforeMethod
	public void setbrowser() throws InterruptedException {

		setupbrowser();
		pom = new pom();
		pom.clkappoint();
		Thread.sleep(2000);
		pom.enteruser(prop.getProperty("userid"));
		Thread.sleep(2000);
		pom.enterpass(prop.getProperty("password"));
		Thread.sleep(2000);
		pom.loginbutton();
		Thread.sleep(2000);
		screenshots("successfull login to make appointment");

	}

	@Test
	public void emptyvalues() throws InterruptedException {

		pom.clkbook();
		Thread.sleep(1000);

		pom.emptyerror();
		Thread.sleep(1000);
		
		screenshots("Without entering any details");
	}

	@Test
	public void enterdetails() throws InterruptedException {

		pom.facility();
		Thread.sleep(2000);

		String dvalues = prop.getProperty("drop");

		if (dvalues.equals("Tokyo CURA Healthcare Center")) {
			pom.clicktokyo();
		} else if (dvalues.equals("Hongkong CURA Healthcare Center")) {
			pom.clickhongkong();
		} else {
			pom.clicksoul();
		}

		pom.clickcheckbox();
		Thread.sleep(2000);

		String option = prop.getProperty("options");

		if (option.equals("Medicare")) {
			pom.clickmedicare();
		} else if (option.equals("Medicaid")) {
			pom.clickmedicaid();
		} else {
			pom.clicknone();
		}

		Thread.sleep(2000);

		pom.clkdate();

		Thread.sleep(1000);

		String monthyear = pom.monthyeartext();

		int year = Integer.parseInt(prop.getProperty("year"));
		int currentyear = Integer.parseInt(prop.getProperty("currentyear"));

		if (year >= currentyear) {
			while (!(getMonthYear(monthyear)[0].equals(prop.getProperty("month"))
					&& getMonthYear(monthyear)[1].equals(prop.getProperty("year")))) {
				pom.nextbutton();
				monthyear = pom.monthyeartext();
			}
		} else if (year < currentyear) {

			while (!(getMonthYear(monthyear)[0].equals(prop.getProperty("month"))
					&& getMonthYear(monthyear)[1].equals(prop.getProperty("year")))) {
				pom.previousbutton();
				monthyear = pom.monthyeartext();
			}
		}

		try {
			driver.findElement(By.xpath("//tr//td[text()='" + prop.getProperty("day") + "']")).click();
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Date is invalid");
		}
		Thread.sleep(2000);

		pom.entercomment(prop.getProperty("comment"));
		Thread.sleep(1000);
		
		screenshots("After filling all details ");

		pom.clkbook();
		Thread.sleep(1000);

		String expect = "Appointment Confirmation";
		
		screenshots("After Appoint Confirm");

		Assert.assertEquals(pom.confirmappoint(), expect);

		Assert.assertEquals(pom.compareFacility(), prop.getProperty("drop"));
		Assert.assertEquals(pom.comparemission(), "Yes");
		Assert.assertEquals(pom.compareprogram(), prop.getProperty("options"));
		Thread.sleep(1000);
		
		screenshots("After Details matched");

	}

	@AfterMethod
	public void driverclose() {

		driver.close();
	}
}
