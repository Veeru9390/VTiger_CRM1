package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.TabNames;
import genericUtilities.WebDriverUtility;

public class HomePage {

	// Step - 1 : Decleration
	
	private String commonPathFroTabs = "//a[contains(@href,'%s&action=index')]";
	
	@FindBy(xpath = "//a[contains(@href,'Accounts&action=index')]")
	private WebElement organizationsTab;
	
	@FindBy(xpath = "//a[contains(@href,'Contacts&action=index')]")
	private WebElement contactsTab;
	
	@FindBy(xpath = "//a[conatains(@href, 'Leeads&action=index')]")
	private WebElement leadsTab;
	
	@FindBy(id = "qccombo")
	private WebElement quickCreateDD;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminWidget;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	//Step - 2 : Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step - 3 : Utilization
	
	/**
	 * This method clicks on specified tab
	 * @param driverUtil
	 * @param tabName
	 */
	public void clickRequiredTab(WebDriverUtility driverUtil, TabNames tabName)
	{
		driverUtil.convertDynamicXpathToWebElement(commonPathFroTabs, tabName.getTabName()).click();
	//	driverUtil.convertDynamicXpathToWebElement(commonPathFroTabs, tabName.getTabName()).click();
	}
	
//	/**
//	 * This method clicks on Organizations tab
//	 */
//	public void clickOrganizationTab()
//	{
//		organizationsTab.click();
//	}
//	/**
//	 * This method clicks on Contacts tab
//	 */
//	public void clickContactsTab()
//	{
//		contactsTab.click();
//	}
//	
//	/**
//	 * 	This method clicks on Leads tab
//	 */
//	public void clickLeadsTab()
//	{
//		leadsTab.click();
//	}
	/**
	 * This method is used to sign out of vtiger
	 * @param driverUtil
	 */
	public void signOutOfVtiger(WebDriverUtility driverUtil)
	{
		driverUtil.mouseHover(adminWidget);
		signOutLink.click();
	}
	
	/**
	 * This method is used to select an option from quick create drop down
	 * @param driverUtil
	 * @param value
	 */
	public void selectFromQuickCreateDD(WebDriverUtility driverUtil, String value)
	{
		driverUtil.handleDropdown(quickCreateDD, value);
	}
}
