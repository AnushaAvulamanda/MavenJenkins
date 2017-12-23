package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;


public class ViewLead extends ProjectMethods  {

	public ViewLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not Home Page", "FAIL");
		}
	}
	
	@FindBy(how=How.ID,using="viewLead_firstName_sp")
	public WebElement eleLeadLink;
	public ViewLead verifyFirstName(String fname) {
		verifyPartialText(eleLeadLink, fname);
		return this;
	}
	@FindBy(how=How.LINK_TEXT,using="Find Leads")
	public WebElement elefindLead;
	
	public FindLead clickFindLead(){
		click(elefindLead);
		return new FindLead(driver, test);
	}
	
	@FindBy(how=How.ID,using="viewLead_companyName_sp")
	public WebElement eleCompanyName;
	public ViewLead verifyCompanyName(String CompanyName) {
		verifyPartialText(eleCompanyName, CompanyName);
		return this;
	}
	@FindBy(how=How.LINK_TEXT,using="Edit")
	public WebElement eleEditLeadLink;
	public EditLead clickEditLeadLink(){
		click(eleEditLeadLink);
		return new EditLead(driver, test);
	}
	@FindBy(how=How.LINK_TEXT,using="Duplicate Lead")
	public WebElement eleDuplicateLeadLink;
	public DuplicateLead clickDuplicateLeadLink(){
		click(eleDuplicateLeadLink);
		return new DuplicateLead(driver, test);
	}
	@FindBy(how=How.LINK_TEXT,using="Delete")
	public WebElement eleDeleteLeadLink;
	public MyLeads clickDeleteLeadLink(){
		click(eleDeleteLeadLink);
		return new MyLeads(driver, test);
	}
	
	

	
	
}
