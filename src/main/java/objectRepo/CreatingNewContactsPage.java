package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.TabNames;
import genericUtilities.WebDriverUtility;

public class CreatingNewContactsPage {

	// Step - 1 : Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement PageHeader;
	
	@FindBy(name = "lastname")
	private WebElement contactLastNameTF;
	
	@FindBy(xpath = "//input[contains(@title,'Save')]")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//img[contains(@onclick,'Accounts')]")
	private WebElement organizationPlusBTN;
	
	private String organizationPath = "//[text()='%s']";
	
	// Step - 2 : Intilialization
	public CreatingNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step - 3 : Utilization
	public String getPageHeader()
	{
		return PageHeader.getText();
	}
	
	/**
	 * This method sets the organization name into the Organization Name Text Fileld
	 * @param name
	 */
	public void setContactLastName(String name)
	{
		contactLastNameTF.sendKeys(name);
	}
	
	/**
	 * This method clicks on Save Button
	 */
	public void clickSaveBTN()
	{
		saveBTN.click();
	}
	
	public void selectExistingOrganization(WebDriverUtility driverUtil, String orgName)
	{
		organizationPlusBTN.click();
		driverUtil.switchToFrame("Accounts");
		driverUtil.convertDynamicXpathToWebElement(organizationPath, orgName).click();
		driverUtil.switchToWindow("Contacts");
	}


	
}
