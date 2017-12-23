package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;


public class FindLeadPop extends ProjectMethods {


	public FindLeadPop(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
		if(!verifyTitle("Find Leads")){
			reportStep("This is not Find Leads Page", "FAIL");
		}
	}
	@FindBy(how=How.NAME,using="firstName")
	private WebElement elefindFirstName;
	public FindLeadPop enterFirstName(String findfistname){
		type(elefindFirstName, findfistname);
		return this;

	}
	@FindBy(how=How.XPATH,using="//button[text()='Find Leads']")
	private WebElement eleFindleadsButton;
	public FindLeadPop clickFindleadsButton(){
		click(eleFindleadsButton);
		return this;
	}
	@FindBy(how=How.XPATH,using="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	private WebElement eleGetResultingLeads;
	public String getFirstResultingLead(){	
		return 	getText(eleGetResultingLeads);
	}

	@FindBy(how=How.XPATH,using="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	private WebElement eleResultingLeads;
	public MergeLead clickResultingLeads(){
		clickWithNoSnap(eleResultingLeads);
		switchToWindow(0);
		return new MergeLead(driver, test);
	}
}