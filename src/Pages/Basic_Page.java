package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Basic_Page {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;

	public Basic_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		this.driver = driver;
		this.waiter = waiter;
		this.js = js;
	
}
}
