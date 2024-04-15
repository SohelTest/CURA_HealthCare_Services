package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import exceldata.lognegativedetails;
import pom.pom;

public class Loginpage extends base{
	
	pom pom;
	
	public Loginpage() {
		super();
	}
	
	@BeforeMethod
	public void beforepage() {
		
		setupbrowser();
		pom = new pom();
	}
	
	@Test
	public void successfulllogin() throws InterruptedException {
		
		pom.clkappoint();
		Thread.sleep(2000);
		pom.enteruser(prop.getProperty("userid"));
		Thread.sleep(2000);
		pom.enterpass(prop.getProperty("password"));
		Thread.sleep(2000);
		pom.loginbutton();
		Thread.sleep(2000);
		
		
		String expectTitle = "CURA Healthcare Service";
		Assert.assertEquals(pom.verifypage(), expectTitle);
		
		screenshots("successfulllogin");
	}
	
	
	@DataProvider
	public Object[][] logdetails(){
		
		Object[][] result = lognegativedetails.readdata("Sheet1");
		return result;
	}
	
	@Test(priority = 2, dataProvider = "logdetails")
	public void negativelogin1(String name,String password) throws InterruptedException {
		
		pom.clkappoint();
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		pom.enteruser(name);
		pom.enterpass(password);
		
		pom.loginbutton();
		Thread.sleep(2000);

		String expecterror = "Login failed! Please ensure the username and password are valid.";
		
		Assert.assertEquals(pom.errorloginmsg(), expecterror);
		
		screenshots("negativelogin1");
		
		
		
		
	}
	
	@AfterMethod 
	public void driverclose() {
		driver.close();
	}
	

}
