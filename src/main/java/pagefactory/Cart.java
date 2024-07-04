package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Cart {

	public int TimeoutValue = 60;

	public Cart(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	@FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
	private WebElement checkOutButton;

	public void checkOutButtonClick() {
		checkOutButton.click();
	}
}
