package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import wdMethods.ProjectMethods;


public class TC004_DeleteLead extends ProjectMethods{

	@BeforeClass
	public void setData() {
		testCaseName="TC005_DeleteLead";
		testDescription="Delete a Lead - LeafTaps";
		browserName="chrome";
		dataSheetName="TC004";
		category="Sanity";
		authors="Gopi";
	}

	@Test(dataProvider="fetchData")
	public void deleteLead(String userName, String password, String phoneNum,String errorMsg){

	String firstResultingLead=new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFALink()
		.clickLeadLink()		
		.clickFindLead()
		.clickPhoneTab()
		.enterPhoneNumberField(phoneNum)
		.clickFindleadsButton()
		.getFirstResultingLead();
	new FindLead(driver, test)
		.clickFirstResultingLead()
		.clickDeleteLeadLink()
		.clickFindLead()
		.enterLeadId(firstResultingLead)
		.clickFindleadsButton()
		.verifyErrorMsg(errorMsg);
	}
}
