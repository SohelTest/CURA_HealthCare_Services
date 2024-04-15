package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.base;

public class pom extends base {
	
	@FindBy(xpath = "//a[@id='btn-make-appointment']")
	WebElement getappoint;
	
	@FindBy(xpath = "//input[@id = 'txt-username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id = 'txt-password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='btn-login']")
	WebElement logbutton;

	@FindBy(xpath = "//p[text()='Login failed! Please ensure the username and password are valid.']")
	WebElement wrongDetailsError;
	
	@FindBy(xpath = "//select[@id='combo_facility']")
	WebElement facility;
	
	@FindBy(xpath = "//select//option[@value='Tokyo CURA Healthcare Center']")
	WebElement tokyo;
	
	@FindBy(xpath = "//select//option[@value='Hongkong CURA Healthcare Center']")
	WebElement hongkong;
	
	@FindBy(xpath = "//select//option[@value='Seoul CURA Healthcare Center']")
	WebElement soul;
	
	
	@FindBy(xpath = "//label//input[@id='chk_hospotal_readmission']")
	WebElement checkbox;
	
	@FindBy(xpath = "//label//input[@id='radio_program_medicare']")
	WebElement medicare;
	
	@FindBy(xpath = "//label//input[@id='radio_program_medicaid']")
	WebElement medicaid;
	
	@FindBy(xpath = "//label//input[@id='radio_program_none']")
	WebElement none;
	
	@FindBy(xpath = "//input[@id='txt_visit_date']")
	WebElement date;
	
	@FindBy(xpath = "//textarea[@id='txt_comment']")
	WebElement comment;
	
	@FindBy(xpath = "//button[@id='btn-book-appointment']")
	WebElement book;
	
	@FindBy(xpath = "//tr//th[text()='April 2024']")
	WebElement emptyerror;
	
	@FindBy(xpath="//th[@class = 'datepicker-switch']")
	WebElement monthyear;
	
	@FindBy(xpath="//table[@class = 'table-condensed']//tr//th[@class='next']")
	WebElement nextcal;
	
	@FindBy(xpath="//th[@class='prev']")
	WebElement precal;
	
	@FindBy(xpath="//div//h2[text()='Appointment Confirmation']")
	WebElement appointconfirm;
	
	@FindBy(xpath="//p[@id='facility']")
	WebElement compareFacility;
	
	@FindBy(xpath="//p[@id='hospital_readmission']")
	WebElement comparereadmission;
	
	@FindBy(xpath="//p[@id='program']")
	WebElement compareProgram;
	
	public pom() {
		
		PageFactory.initElements(driver, this);
	}
	public void clkappoint() {
		
		getappoint.click();
	}
	public String verifypage() {
		return driver.getTitle();
	}
	public void enteruser(String user) {
		
		username.sendKeys(user);
	}
	
	public void enterpass(String pass) {
		password.sendKeys(pass);
	}
	
	public void loginbutton() {
		
		logbutton.click();
	}
	
	public String errorloginmsg() {
		return wrongDetailsError.getText();
	}
	
	public void facility() {
		facility.click();
	}
	
	public void clicktokyo() {
		tokyo.click();
	}

	public void clickhongkong() {
		hongkong.click();
	}
	
	public void clicksoul() {
		soul.click();
	}
	
	public void clickcheckbox() {
		checkbox.click();
	}
	
	public void clickmedicare() {
		medicare.click();
	}
	
	public void clickmedicaid() {
		medicaid.click();
	}
	public void clicknone() {
		none.click();
	}
	
	public void clkbook() {
		book.click();
	}
	
	public void emptyerror() {
		emptyerror.isDisplayed();
	}
	
	public void clkdate() {
		date.click();
	}
	
	public String monthyeartext() {
		return monthyear.getText();
	}
	
	public void nextbutton() {
		nextcal.click();
	}
	
	public void previousbutton() {
		precal.click();
	}
	
	public void entercomment(String paragraph) {
		comment.sendKeys(paragraph);
	}
	
	public String confirmappoint() {
		return appointconfirm.getText();
	}
	
	public String compareFacility() {
		return compareFacility.getText();
	}
	
	public String comparemission() {
		return comparereadmission.getText();
	}
	
	public String compareprogram() {
		return compareProgram.getText();
	}
}

