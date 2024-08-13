package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements with locators and respective business libraries of Organization
 */
public class OrganizationsPage {

	// Step - 1 : Declaration
	@FindBy(xpath = "//img[alt='Create Organization...']")
	private WebElement CreateOrgBTN;
	
	// Step - 2 : Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**	
	 * 	This method clicks on the create organization page
	 */
	//Step - 3 : Utilization
	public void clickCreateOrgBTN()
	{
		CreateOrgBTN.click();
	}
	
}
