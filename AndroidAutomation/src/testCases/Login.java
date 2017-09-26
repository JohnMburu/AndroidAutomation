package testCases;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; //Used to set device properties:device name, platform, version, app package name, activity name, etc. It has various methods eg. setCapability()-> used to set the device name, platform version, platform name, absolute path of the app under test (the .apk file of the app(Android) under test), app Activity (in Android) and appPackage(java).
import org.testng.annotations.AfterTest; //@AfterTest annotated method will be executed when all @Test annotated methods completed its execution
import org.testng.annotations.BeforeTest; //@Before Test annotated method will be executed before any @Test method
import org.testng.annotations.Test; //@Test annotation describes method as a test method or part of your test

public class Login {
	AndroidDriver driver;

	@BeforeTest
	public void SplashScreen() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZY2234ZDFF"); // obtained from the command "adb devices"
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "5.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "ch.clickon.apps.mwceasy");
		capabilities.setCapability("appActivity", "ch.clickon.apps.mwceasy.ui.LauncherActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	}

	@Test
	public void Login() {
		//Declare Variables
		String Username = "mburujr@gmail.com";
		String Password = "Pass12345";
		
		driver.findElement(By.xpath(
				"//android.widget.EditText[contains(@resource-id,'ch.clickon.apps.mwceasy:id/etLoginUsername')]"))
				.click(); // Click on the Email field
		System.out.println("\n Clicking on the User Name Textfield. ");
		driver.findElement(By.xpath(
				"//android.widget.EditText[contains(@resource-id,'ch.clickon.apps.mwceasy:id/etLoginUsername')]"))
				.sendKeys(Username); // Input Email
		System.out.println("\n User Name Entered = " + Username );
		driver.findElement(By.xpath(
				"//android.widget.EditText[contains(@resource-id,'ch.clickon.apps.mwceasy:id/etLoginPassword')]"))
				.click(); // Click on the password field
		System.out.println("\n Clicking on the Password Textfield. ");		
		driver.findElement(By.xpath(
				"//android.widget.EditText[contains(@resource-id,'ch.clickon.apps.mwceasy:id/etLoginPassword')]"))
				.sendKeys(Password); // Click on the password field
		System.out.println("\n User Name Entered = " + Password );
		
		driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click(); // Click on submit button
		System.out.println("\n Submit Button Clicked!");
		
		String Button = driver.findElement(By.xpath("//android.widget.Button[@index='3']")).getAttribute("text");
		System.out.println("===> " + Button);
	}

	@AfterTest
	public void end() {
		
		driver.quit(); // Close application
	}
}