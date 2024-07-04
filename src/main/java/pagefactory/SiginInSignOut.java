package pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SiginInSignOut {

	public int TimeoutValue = 60;

	public SiginInSignOut(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}


	@FindBy(xpath="//*[@id=\"user-name\"]")
	private WebElement user;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"login-button\"]")
	private WebElement loginButton;
	
	public void enterUser() {
		user.sendKeys("standard_user");
	}
	public void enterPassword() {
		password.sendKeys("secret_sauce");
	}
	public void clickSignIn() {
		loginButton.click();
	}
}
