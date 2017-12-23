package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class CreateLead  extends ProjectMethods {


	public CreateLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Create Lead Page", "FAIL");
		}
	}


	@FindBy(how=How.ID,using="createLeadForm_companyName")
	private WebElement companyName;

	public CreateLead enterCompanyName(String comnyName){
		type(companyName, comnyName);
		return this;

	}

	@FindBy(how=How.ID,using="createLeadForm_firstName")
	private WebElement eleFirstName;

	public CreateLead enterFirstName(String firstName){
		type(eleFirstName, firstName);
		return this;
	}

	@FindBy(how=How.ID,using="createLeadForm_lastName")
	private WebElement eleLastName;
	public CreateLead enterLastName(String lastName){
		type(eleLastName, lastName);
		return this;

	}

	@FindBy(how=How.CLASS_NAME,using="smallSubmit")
	private WebElement eleCreateLeadSubmit;
	public ViewLead clickCreateLeadSubmit(){
		click(eleCreateLeadSubmit);
		return new ViewLead(driver, test);
	}
	
	@FindBy(how=How.ID,using="createLeadForm_primaryEmail")
	private WebElement eleEmail;
	public CreateLead enterEmail(String eMail){
		type(eleEmail, eMail);
		return this;
	}
}
