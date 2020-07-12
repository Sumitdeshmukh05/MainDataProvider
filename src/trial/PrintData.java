package trial;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintData {
	
	WebDriver driver;
	WebElement element;
	
	@Test(dataProvider = "TestData")
	public void PrintD(String id, String pass) throws InterruptedException, MalformedURLException{

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\E0360088\\eclipse-workspaceNew\\MainDataProvider\\chromedriver.exe");
//		driver = new ChromeDriver();
		
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setBrowserName("chrome");
//		WebDriverManager.chromedriver().setup();
//		driver = new RemoteWebDriver(new URL("http://192.168.1.101:4444/wd/hub"), capabilities);
		
		ChromeOptions cap1 = new ChromeOptions(); 
		cap1.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		                  UnexpectedAlertBehaviour.IGNORE);
		driver = new ChromeDriver(cap1);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https:\\www.facebook.com");
		
		element = driver.findElement(By.xpath("//input[@class='inputtext login_form_input_box' and @name='email']"));
		Thread.sleep(3000);
		element.sendKeys(id);
		
		element = driver.findElement(By.xpath("//input[@class='inputtext login_form_input_box' and @name='pass']"));
		Thread.sleep(3000);
		element.sendKeys(pass);
		
		element = driver.findElement(By.xpath("//label[@id='loginbutton']"));
		element.click();
		
		element = driver.findElement(By.xpath("//span[text()='Log in to Facebook']"));
		
		Assert.assertEquals(element.isDisplayed(), true);
		
		System.out.println("Iteration Executed successfully");
		
	}
	
	
	@DataProvider(name="TestData")
	public Object[][] getdata(){
		
		ReadData rd = new ReadData("C:\\Users\\E0360088\\eclipse-workspaceNew\\MainDataProvider\\DataDrivenFile3.xlsx");
		int i = 0;
		i = rd.GetCountofRows("Sheet1");
		System.out.println("Row Count in file : "+i);
		
		Object[][] credentials= new Object[i][2];
		
		for(int j=0; j<i; j++)
		{
			credentials[j][0] = rd.ReadCellData("Sheet1", j, 0);
			
			credentials[j][1] = rd.ReadCellData("Sheet1", j, 1);
			
		}
		
		return credentials;
		
		
		
	}
	


}
