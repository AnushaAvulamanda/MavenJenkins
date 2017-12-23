package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;


public class HomePage extends ProjectMethods  {

	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Home Page", "FAIL");
		}
	}


	@FindBy(how=How.XPATH,using="//h2[text()[contains(.,'Demo')]]")
	public WebElement eleLoggedName;

	public HomePage verifyLoggedName(String data) {
		verifyPartialText(eleLoggedName, data);
		return this;
	}

	@FindBy(how=How.LINK_TEXT,using="CRM/SFA")
	public WebElement eleCRMSFALink;

	public MyHome clickCRMSFALink(){
		click(eleCRMSFALink);
		return new MyHome(driver, test);
	}

	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogOut;
	
	public LoginPage clickLogout() {
		click(eleLogOut);
		return new LoginPage(driver,test);

	}



}
