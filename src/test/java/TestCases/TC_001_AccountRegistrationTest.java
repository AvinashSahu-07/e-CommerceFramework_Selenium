package TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void test_account_Registration() throws InterruptedException
	{
		
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");

		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString());
		
		regpage.setLastName(randomeString());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(600,1000)");
		
		
		regpage.setPrivacyPolicy();
		
		
		
		regpage.clickContinue();
		
		
		
		String confmsg=regpage.getConfirmationMsg();
		System.out.println(confmsg);
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");

		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
//		catch(Exception e)
//		{
//			Assert.fail("Test failed");
//		}
	}
	


}
