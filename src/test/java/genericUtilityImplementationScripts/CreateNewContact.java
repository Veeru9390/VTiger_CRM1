package genericUtilityImplementationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewContact {

	public static void main(String[] args) throws InterruptedException {
		// Set up the Chrome driver
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Navigate to vtigerCRM login page
		driver.get("http://localhost:8888/");

		// Enter login credentials
		WebElement usernameInput = driver.findElement(By.name("user_name"));
		usernameInput.sendKeys("admin");
		WebElement passwordInput = driver.findElement(By.name("user_password"));
		passwordInput.sendKeys("password");

		// Click login button
		WebElement loginButton = driver.findElement(By.name("Login"));
		loginButton.click();

		// Click on Contacts module
		WebElement contactsModule = driver.findElement(By.linkText("Contacts"));
		contactsModule.click();

		// Click on Create Contact button
		WebElement createContactButton = driver.findElement(By.cssSelector("[title='Create Contact']"));
		createContactButton.click();

		// Select existing organization
		WebElement organizationSelect = driver.findElement(By.name("search"));
		organizationSelect.sendKeys("Existing Organization");

		// Enter contact details
		WebElement firstNameInput = driver.findElement(By.name("first_name"));
		firstNameInput.sendKeys("John");
		WebElement lastNameInput = driver.findElement(By.name("last_name"));
		lastNameInput.sendKeys("Doe");

		// Save contact
		WebElement saveButton = driver.findElement(By.name("Save"));
		saveButton.click();

		// Log out of vtigerCRM
		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		logoutLink.click();

		// Close the browser
		driver.quit();
	}

}
