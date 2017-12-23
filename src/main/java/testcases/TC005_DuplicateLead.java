package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import wdMethods.ProjectMethods;


public class TC005_DuplicateLead extends ProjectMethods{

	@BeforeClass
	public void setData() {
		testCaseName="TC005_DuplicateLead";
		testDescription="Duplicate a Lead - LeafTaps";
		browserName="chrome";
		dataSheetName="TC005";
		category="Regression";
		authors="Babu";
	}

	@Test(dataProvider="fetchData")
	public void duplicateLead(String userName, String password ,String emailAddress) throws InterruptedException{

		String fName=new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()		
		.clickCRMSFALink()		
		.clickLeadLink()		
		.clickFindLead()
		.clickEmailTab()
		.enterEmailAddress(emailAddress)
		.clickFindleadsButton()
		.getFirstResultingFirstName();
		new FindLead(driver, test)
		.clickFirstResultingLead()
		.clickDuplicateLeadLink()
		.clickCreateLeadDublicate()
		.verifyFirstName(fName);
		
	}

}
