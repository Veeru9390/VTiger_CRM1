package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements, locators and respective business libraries of Contacts Page
 */
public class ContactsPage {

	// Step - 1 : Declaration
		@FindBy(xpath = "//img[alt='Create Contact...']")
		private WebElement CreateContactBTN;
		
		// Step - 2 : Initialization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		// Step - 3 : Utilization
		/**
		 * This method clicks on the create contact button
		 */
		public void clickCreateContactsBTN()
		{
		CreateContactBTN.click();
		}
}
