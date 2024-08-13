package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class contains elements, locators and respective business libraries
 * @author user
 */
public class LoginPage {

	// Step - 1 : Declaration
	@FindBy(name = "user_name")
	private WebElement usernameTF;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTF;
	
	@FindBy(id = "submitButton")
	private WebElement loginBTN;
	
	// Step - 2 : Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This method logs into vtiger application
	 * @param username
	 * @param password
	 */
	// Step - 3 : Utilization
	public void loginToVtiger(String username, String password)
	{
		usernameTF.sendKeys(username);
		PasswordTF.sendKeys(password);
		loginBTN.submit();
	}
	
}
