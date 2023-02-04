package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name = "firstname")
	WebElement textFirstname;

	@FindBy(name = "lastname")
	WebElement textLasttname;

	@FindBy(name = "email")
	WebElement textEmail;

	@FindBy(name = "password")
	WebElement textPassword;

	@FindBy(name = "agree")
	WebElement checkdPolicy;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonContinue;

	@FindBy(css ="div[id='content'] h1")
	WebElement messageConfirmation;

	public void setFirstName(String fname) {
		textFirstname.sendKeys(fname);

	}

	public void setLastName(String lname) {
		textLasttname.sendKeys(lname);

	}

	public void setEmail(String email) {
		textEmail.sendKeys(email);

	}


	public void setPassword(String pwd) {
		textPassword.sendKeys(pwd);

	}
	public void setPrivacyPolicy() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", checkdPolicy);
	}

	public void clickContinue() {
		//sol1 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", buttonContinue);
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}

	public String getConfirmationMsg() {
		try {
			return (messageConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
//		String msg= messageConfirmation.getText();
//		System.out.println(msg);
	}

	

}
