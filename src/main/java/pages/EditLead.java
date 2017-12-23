package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;


public class EditLead extends ProjectMethods {
	
	
	public EditLead(RemoteWebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test = test;
			PageFactory.initElements(driver, this);
			if(!verifyTitle("opentaps CRM")){
				reportStep("This is not Edit Lead Page", "FAIL");
			}
		}
	@FindBy(how=How.ID,using="updateLeadForm_companyName")
	private WebElement eleupdateCompanyName;
     	public EditLead updateCompanyName(String updcomnyName){
		type(eleupdateCompanyName, updcomnyName);
		return this;
		
	    }
     	@FindBy(how=How.CLASS_NAME,using="smallSubmit")
    	private WebElement eleUpdateSubmit;
     	public ViewLead clickUpdateSubmit(){
			click(eleUpdateSubmit);
			return new ViewLead(driver, test);
		}
		
}
     	
