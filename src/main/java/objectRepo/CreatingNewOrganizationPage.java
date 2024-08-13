package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

/**
 * This class contains elements, locators and respective business libraries of Creating module
 * @author user
 */
public class CreatingNewOrganizationPage {

	//Step - 1: Declaration
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name="accountname")
	private WebElement OrganizationNameTF;
	
	@FindBy(xpath = "//input[contains(@title,'Save')]")
	private WebElement SaveBTN;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	// Step - 2 : Initialization
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method fetches the page header
	 * @return String
	 */
	// Step - 3 : Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	/**
	 * This method sets the organization name into the organization text field
	 * @param name
	 */
	public void setOrganizationName(String name)
	{
		OrganizationNameTF.sendKeys(name);
	}
	
	/**
	 * This method clicks on Save Button
	 */
	public void clickSaveBTN()
	{
		SaveBTN.click();
	}
	
	/**
	 * THis method is used to select an industry from industry drop down
	 * @param driverUtil
	 * @param value
	 */
	public void selectFromIndustryDD(WebDriverUtility driverUtil, String value)
	{
		driverUtil.handleDropdown(industryDD, value);
	}
	
	/**
	 * This method is used to select a type from type drop down
	 * @param driverUtil
	 * @param value
	 */
	public void selectFromTypeDD(WebDriverUtility driverUtil, String value)
	{
		driverUtil.handleDropdown(typeDD, value);
	}
}
