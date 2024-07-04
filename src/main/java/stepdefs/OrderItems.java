package stepdefs;

import org.openqa.selenium.WebDriver;

import driverfactory.WebDriverFactory;
import io.cucumber.java.en.Given;
import pagefactory.Inventory;
import pagefactory.SiginInSignOut;
import pagefactory.Cart;
import pagefactory.CheckOutInformation;

public class OrderItems {

	private WebDriver driver;
	private Inventory inventory;
	private Cart cart;
	private CheckOutInformation checkOutInfo;

	public OrderItems() {
		this.driver = WebDriverFactory.getDriver();
		this.inventory = new Inventory(driver);
		this.checkOutInfo = new CheckOutInformation(driver);
		this.cart = new Cart(driver);
	}

	@Given("User selects any two items and clicks on Cart button")
	public void selectItemsCartThem() throws InterruptedException {

		Thread.sleep(2000);
		inventory.sauceLabsBackPackButtonClick();
		inventory.sauceLabsBackLightButtonClick();
		inventory.clcikcartContainerButton();
	}

	@Given("User Checkout and enters address details")
	public void checkOut() throws InterruptedException {
		Thread.sleep(1000);
		cart.checkOutButtonClick();
	}

	@Given("User Continue to Overview and finish Order")
	public void continueAndFinishOrder() throws InterruptedException {
		Thread.sleep(1000);
		checkOutInfo.enterFirstName();
		checkOutInfo.enterLasttName();
		checkOutInfo.enterZipCode();
		checkOutInfo.clickContinue();
		checkOutInfo.clickFinish();
	}
}
