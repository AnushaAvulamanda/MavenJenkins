package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class MyHome extends ProjectMethods {

	public MyHome(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);

		if(!verifyTitle("My Home | opentaps CRM")){
			reportStep("This is not My Home Page", "FAIL");
		}
	}

	@FindBy(how=How.LINK_TEXT,using="Leads")
	public WebElement eleLeadLink;
	// Click Leads 
	public MyLeads clickLeadLink(){
		click(eleLeadLink);
		return new MyLeads(driver, test);
	}


}
