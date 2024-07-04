package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckOutInformation {

	public int TimeoutValue = 60;

	public CheckOutInformation(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	@FindBy(xpath = "//*[@id=\"first-name\"]")
	private WebElement firstName;

	@FindBy(xpath = "//*[@id=\"last-name\"]")
	private WebElement lastName;

	@FindBy(xpath = "//*[@id=\"postal-code\"]")
	private WebElement zipCode;

	@FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
	private WebElement continueButton;

	@FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")
	private WebElement finishButton;

	public void enterFirstName() {
		firstName.sendKeys("Sadakar");
	}

	public void enterLasttName() {
		lastName.sendKeys("Pochampalli");
	}

	public void enterZipCode() {
		zipCode.sendKeys("502319");
	}

	public void clickContinue() {
		continueButton.click();
	}

	public void clickFinish() {
		finishButton.click();
	}

}
