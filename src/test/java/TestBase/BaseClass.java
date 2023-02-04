package TestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Logger logger;
	public WebDriver driver;
	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		rb = ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());
		
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("appURL")); // get url from config.properties file
		driver.manage().window().maximize();

	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Screenshots//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//Screenshots//" + testCaseName + ".png";
		
		
	}
	


}
