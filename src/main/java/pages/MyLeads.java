package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;


public class MyLeads extends ProjectMethods {

	public MyLeads(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);

		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is not My Leads Page", "FAIL");
		}
	}
	
	@FindBy(how=How.LINK_TEXT,using="Create Lead")
	public WebElement elecreateLead;
	// Click Create Leads 
	public CreateLead clickCreateLead(){
		click(elecreateLead);
		return new CreateLead(driver, test);
	}

	@FindBy(how=How.LINK_TEXT,using="Find Leads")
	public WebElement elefindLead;
	
	public FindLead clickFindLead(){
		click(elefindLead);
		return new FindLead(driver, test);
	}
	
	@FindBy(how=How.LINK_TEXT,using="Merge Leads")
	public WebElement elemergeLead;
	
	public MergeLead clickMergeLead(){
		click(elemergeLead);
		
		return new MergeLead(driver, test);
	}
	
	

}
