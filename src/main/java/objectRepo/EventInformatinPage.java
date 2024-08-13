package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements, locators and respective business libraries of Event Informatin page
 * @author user
 */
public class EventInformatinPage {

	//Step - 1 : Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//input[@name='Delete']")
	private WebElement deleteBTN;
	
	//Step - 2 : Initialization
	public EventInformatinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step - 3 : Utilization
	
	/**
	 * This method returns page header
	 * @return String
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	/**
	 * THis method clicks on delete button
	 */
	public void clickDeleteBTN()
	{
		deleteBTN.click();
	}
	
	
	
}
