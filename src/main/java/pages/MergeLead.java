package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;


public class MergeLead extends ProjectMethods {
	
	
	public MergeLead(RemoteWebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test = test;
			PageFactory.initElements(driver, this);
			if(!verifyTitle("Merge Leads | opentaps CRM")){
				reportStep("This is not Merge Leads Page", "FAIL");
			}
		}
	@FindBy(how=How.XPATH,using="(//img[@alt='Lookup'])[1]")
	public WebElement eleFromLeadLookup;
	public FindLeadPop clickFromLeadLookup(){
		clickWithNoSnap(eleFromLeadLookup);
		switchToWindow(1);
		return new FindLeadPop(driver, test);		
	}
	
	@FindBy(how=How.XPATH,using="(//img[@alt='Lookup'])[2]")
	public WebElement eleToLeadLookup;
	public FindLeadPop clickToLeadLookup(){
		clickWithNoSnap(eleToLeadLookup);
		switchToWindow(1);
		return new FindLeadPop(driver, test);		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Merge")
	public WebElement eleclickMergeButton;
	public ViewLead clickMergeButton(){
		clickWithNoSnap(eleclickMergeButton);
		acceptAlert();
		return new ViewLead(driver, test);
	}
}