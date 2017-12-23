package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods  {

	// This is to confirm you are in Login Page
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		// This is to load all the elements in the page
		PageFactory.initElements(driver, this);
		
		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Login Page", "FAIL");
		}
	}
	
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;
	
	// Enter user name in Login Page
	public LoginPage enterUserName(String userName){
		type(eleUserName, userName);
		return this;
	}
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;
	
	// Enter password in Login Page,
	public LoginPage enterPassword(String password){
		type(elePassword, password);
		return this;
		
	}
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogin;
	
	// Click login 
	public HomePage clickLogin(){
		click(eleLogin);
		return new HomePage(driver, test);
	}
	
	// Click login button on negative case
	public LoginPage clickLoginForFailure(){
		click(eleLogin);
		return this;
	}
	
	@FindBy(how=How.ID,using="errorDiv")
	private WebElement eleErrorMessage;
	
	// Verify the error message
	public LoginPage verifyErrorMsg(String text){
		verifyPartialText(eleErrorMessage, text);
		return this;
	}

}
