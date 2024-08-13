package testNGImplementation;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import genericUtilities.BaseClass;
import genericUtilities.TabNames;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.OrganizationInformationPage;
import objectRepo.OrganizationsPage;

//@Listeners(genericUtilities.ListenerImplementation.class)

public class CreateOrgWithTypeAndIndustryTest extends BaseClass {

	@Test(groups = "organizations")
	public void createOrgWithTypeAndIndustryTest() {

		OrganizationsPage organization = pageObjectManager.getOrganization();
		CreatingNewOrganizationPage createOrg = pageObjectManager.getCreateOrg();
		OrganizationInformationPage orgInfo = pageObjectManager.getOrgInfo();

		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);

		soft.assertTrue(driver.getTitle().contains("Organizations"));
//		if (driver.getTitle().contains("Organizations"))
//			System.out.println("Organizations Page is Displayed");
//		else
//			driverUtil.quitAllWindows();

		organization.clickCreateOrgBTN();

		soft.assertTrue(createOrg.getPageHeader().equalsIgnoreCase("creating new organization"));
//		if (createOrg.getPageHeader().equalsIgnoreCase("creating new organization"))
//			System.out.println("Creating New Organization Page is Displayed");
//		else
//			driverUtil.quitAllWindows();

		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization With Industry And Type");
		String orgName = map.get("Organization Name") + jutil.generateRandomNum(100);
		createOrg.setOrganizationName(orgName);
//		createOrg.setOrganizationName(map.get("Organization Name"));
		createOrg.selectFromIndustryDD(driverUtil, map.get("Industry"));
		createOrg.selectFromTypeDD(driverUtil, map.get("Type"));
		createOrg.clickSaveBTN();

		soft.assertTrue(orgInfo.getPageHeader().contains(map.get("orgName")));
//		if (orgInfo.getPageHeader().contains(map.get("Organization Name")))
//			System.out.println("Organization created successfully");
//		else
//			driverUtil.quitAllWindows();

		orgInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");

		soft.assertTrue(driver.getTitle().contains("Organizations"));
		if (driver.getTitle().contains("Organizations")) {
//			System.out.println("Organizations Page is Displayed");
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Pass");
		} else {
//			driverUtil.quitAllWindows();
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Fail");
			soft.assertAll();
		}
	}

}