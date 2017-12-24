package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;


public class TC001_CreateLead extends ProjectMethods{

	@BeforeClass
	public void setData() {
		testCaseName="TC001_CreateLead";
		testDescription="Create a new Lead on LeafTaps";
		browserName="firefox";
		dataSheetName="TC001";
		category="Smoke";
		authors="Gopi";
	}

	@Test(dataProvider="fetchData")
	public void createLead(String userName, String password, String comnyName, String firstName, String lastName, String eMail){

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()		
		.clickCRMSFALink()		
		.clickLeadLink()		
		.clickCreateLead()
		.enterCompanyName(comnyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterEmail(eMail)
		.clickCreateLeadSubmit()		
		.verifyFirstName(firstName);			
	}
}
