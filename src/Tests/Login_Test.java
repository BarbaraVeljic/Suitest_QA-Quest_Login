package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends Basic_Test {

	@Test(priority = 1)
	public void successfulLogin() {
		this.driver.navigate().to(url);
		this.loginPage.logIn(username, password);
		Assert.assertTrue(this.loginPage.successfulLogIn(), "[ERROR] Unexpected login message");
        driver.findElement(By.xpath("//*[@class='user-group']")).click();
        driver.findElement(By.xpath("//*[@data-testid='logoutButton']")).click();

	}

	@Test(priority = 2)
	public void logInWithBlankUsername() {
		this.driver.navigate().to(url);
		this.loginPage.logIn("", password);
		Assert.assertTrue(this.loginPage.getMessageEmailRequired()
				.contains("E-mail is required"), "[ERROR] Unexpected message");
	}

	@Test(priority = 3)
	public void logInWithBlankPassword() {
		this.driver.navigate().to(url);
		this.loginPage.logIn(username, "");
		Assert.assertTrue(this.loginPage.getMessagePasswordRequired()
				.contains("Password is required"), "[ERROR] Unexpected message");
	}

	@Test(priority = 4)
	public void logInWithInvalidUsername() throws InterruptedException {
		this.driver.navigate().to(url);
		this.loginPage.logIn("barbaraveljic@gmail", password);
		Assert.assertTrue(this.loginPage.getMessageInvalidEmail()
				.contains("This doesn't look like a valid e-mail address"), 
				"[ERROR] Unexpected message");
		Thread.sleep(1000);
		this.loginPage.logIn("barbaraveljicgmail.com", password);
		Assert.assertTrue(this.loginPage.getMessageInvalidEmail()
				.contains("This doesn't look like a valid e-mail address"), 
				"[ERROR] Unexpected message");
		Thread.sleep(1000);
		this.loginPage.logIn("barbaraveljic@.com", password);
		Assert.assertTrue(this.loginPage.getMessageInvalidEmail()
				.contains("This doesn't look like a valid e-mail address"),
				 "[ERROR] Unexpected message");

	}

	@Test(priority = 5)
	public void logInWithWrongPassword() throws InterruptedException {
		this.driver.navigate().to(url);
		this.loginPage.logIn(username, "Barbara");
		Thread.sleep(1000);
		Assert.assertTrue(this.loginPage.getMessageWrongPassword()
				.contains("We don't have an account with these credentials"),
				 "[ERROR] Unexpected message");
	}
}
