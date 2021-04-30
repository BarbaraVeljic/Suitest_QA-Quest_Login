package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page extends Basic_Page {

	public Login_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getUserName() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getForgotPassword() {
		return driver.findElement(By.linkText("Forgot password?"));
	}

	public WebElement getLoginBtn() {
		return driver.findElement(By.xpath("//*[@type='submit']"));
	}

	public WebElement getSingUp() {
		return driver.findElement(By.linkText("Sing up"));
	}

	public WebElement getFeatures() {
		return driver.findElement(By.linkText("Features"));
	}

	public WebElement getControlUnits() {
		return driver.findElement(By.linkText("Control Units"));
	}

	public WebElement getPricing() {
		return driver.findElement(By.linkText("Pricing"));
	}

	public WebElement getDocs() {
		return driver.findElement(By.linkText("Docs"));
	}

	public WebElement getJobs() {
		return driver.findElement(By.linkText("Jobs"));
	}

	public WebElement getLoginLink() {
		return driver.findElement(By.linkText("Login"));
	}

	public WebElement getTryNow() {
		return driver.findElement(By.linkText("Try now for free"));
	}

	public void logIn(String username, String password) {
		this.getUserName().clear();
		this.getUserName().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLoginBtn().click();
	}

	public boolean successfulLogIn() {
		boolean success;
		try {
			driver.findElement(By.xpath("//*[@class='icon userIcon icon-user-filled']"));
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	public String getMessageEmailRequired() {
		String message = driver.findElement(By.xpath("//*[@data-testid='emailRequired']")).getText();
		return message;
	}

	public String getMessagePasswordRequired() {
		String message = driver.findElement(By.xpath("//*[@data-testid='passwordRequired']")).getText();
		return message;
	}

	public String getMessageInvalidEmail() {
		String message = driver.findElement(By.xpath("//*[@data-testid='emailIncorrect']")).getText();
		return message;
	}

	public String getMessageWrongCredentials() {
		String message = driver.findElement(By.xpath("//*[@data-testid='infoWrongCredentials']")).getText();
		return message;
	}
}
