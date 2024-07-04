package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Inventory {

	public int TimeoutValue = 60;

	public Inventory(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	@FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[3]/div/button")
	private WebElement menuButton;

	@FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	private WebElement logOutSideBarLink;
	
	
	@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
	private WebElement sauceLabsBackPackButton;
	
	@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")
	private WebElement sauceLabsBackLightButton;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
	private WebElement cartContainerButton;
	

	public void menuButtonClick() {
		menuButton.click();
	}

	public void logOutSideBarLinkClick() {
		logOutSideBarLink.click();
	}
	
	public void sauceLabsBackPackButtonClick() {
		sauceLabsBackPackButton.click();
	}
	public void sauceLabsBackLightButtonClick() {
		sauceLabsBackLightButton.click();
	}
	public void clcikcartContainerButton() {
		cartContainerButton.click();
	}
}
