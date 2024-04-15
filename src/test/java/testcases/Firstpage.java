package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import pom.pom;

public class Firstpage extends base{
	
	pom pom;
	public Firstpage() {
		super();
	}
	
	@BeforeMethod
	public void browser() {
		
		setupbrowser();
		screenshots("login");
		pom = new pom();
	}
	
	@Test(priority =1)
	public void verifyurl() {
		
		String expect = "CURA Healthcare Service";
		System.out.println(pom.verifypage());
		Assert.assertEquals(pom.verifypage(), expect);
		screenshots("verifyURL");
		
	}
	
	@Test(priority =2)
	public void getappoint() throws InterruptedException {
		
		pom.clkappoint();
		Thread.sleep(2000);
		
		screenshots("getappoint");
	}
	
	
	@Test(priority =3)
	public void verifyafterappoint() throws InterruptedException {
		getappoint();
		String expect = "CURA Healthcare Service";
		System.out.println(pom.verifypage());
		Assert.assertEquals(pom.verifypage(), expect);
		
		screenshots("verifyafterappoint");
	}
	
	@AfterMethod
	public void closedriver() {
		driver.close();
	}

}
