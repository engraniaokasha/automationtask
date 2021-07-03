package automationtaskafaqy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import utils.Utils;

public class Account {

	private WebDriver driver;

	public Account(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}	
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}
	
	public WebElement getSignInBtn() {
		return waitToBeClickable(driver, By.className("login"), 30);
	}

	// return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), \"Sign
	// in\")]"), 30);}

	public WebElement getCreateAccountForm() {
		return waitForElementPresence(driver, By.id("create-account_form"), 30);
	}

	public WebElement getCreatAccountEmailField() {
		return waitForElementPresence(driver, By.id("email_create"), 30);
	}

	public WebElement getCreateAccountBtn() {
		return waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	public WebElement getAccountLogout() {
		return waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 30);
	}

	public void setCreateAccountEmailField(String email) {
		WebElement element = this.getCreatAccountEmailField();
		element.clear();
		element.sendKeys(email);
	}

}
