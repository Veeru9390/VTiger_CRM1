package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.PageObjectManager;

public class BaseClass {

	//@BeforeSuite
	//@BeforeTest
	protected PropertiesUtility propertyUtil;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility driverUtil;
	
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected PageObjectManager pageObjectManager;
	
	protected LoginPage login;
	protected HomePage home;
	
	protected SoftAssert soft;
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = "important")
	public void classConfiguration() {
		propertyUtil = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		driverUtil = new WebDriverUtility();

		propertyUtil.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		driver = driverUtil.launchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
//		driver = driverUtil.launchBrowser(browser);
		driver = driverUtil.launchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();

		long time = (Long) jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"), DataType.LONG);
		driverUtil.waitTillElementFound(time);
	
		sdriver = driver;
		sjutil = jutil;	
	}
	
	@BeforeMethod(groups = "important")
	public void methodConfiguration() {
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));

		pageObjectManager = new PageObjectManager(driver);
		login = pageObjectManager.getLogin();
		home = pageObjectManager.getHome();
		
		if (driver.getTitle().contains("vtiger CRM"))
			System.out.println("Login Page Displayed");
		else
			driverUtil.quitAllWindows();

		login.loginToVtiger(propertyUtil.readFromProperties("username"), propertyUtil.readFromProperties("password"));

		if (driver.getTitle().contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			driverUtil.quitAllWindows();
			soft = new SoftAssert();
	}	
	
	@AfterMethod(groups = "important")
	public void methodTeardown() {
		excel.saveExcel(IConstantPath.EXCEL_PATH);
		home.signOutOfVtiger(driverUtil);
	}
	
	@AfterClass(groups = "important")
	public void classTeardown() {
		excel.closeExcel();
		driverUtil.quitAllWindows();
	}
	//@AfterTest
	//@AfterSuite
}