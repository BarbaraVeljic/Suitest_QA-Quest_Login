package Tests;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Pages.Login_Page;

public abstract class Basic_Test {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected Login_Page loginPage;
	protected String username = "barbaraveljic@gmail.com";
	protected String password = "Barbara1";
	protected String url = "https://the.suite.st/login";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driverlib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.loginPage = new Login_Page(driver, waiter, js);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void takeScreenshots(ITestResult result) throws HeadlessException, AWTException, IOException {
		String testTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.jpg'").format(new Date());
		if (ITestResult.FAILURE == result.getStatus()) {
			BufferedImage screenshoots = new Robot()
					.createScreenCapture((new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())));
			File screenshots = new File("screenshot.jpg");
			ImageIO.write(screenshoots, "jpg", new File("screenshots\\" + testTime));

		}
		this.driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void close() {
		driver.quit();

	}
}
