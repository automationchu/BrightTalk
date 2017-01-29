package pages;

import org.openqa.selenium.By;

import utils.WebDriverUtils;

public class LoginPage extends WebDriverUtils{
	
	private final By USER_LOGIN_EMAIL = By.id("user_login_email");
	private final By USER_PASSWORD = By.id("user_login_password");
	private final By LOGIN_BUTTON = By.xpath("//input[@value='Log in']");
	private final By LOGIN_ERROR = By.xpath("//label[@class='error login-failed-error']");
	
	public void enterEmail(String userEmail){
		getElement(USER_LOGIN_EMAIL);
		sendKeys(USER_LOGIN_EMAIL, userEmail);
	}
	
	public void enterPassword(String password){
		sendKeys(USER_PASSWORD, password);
	}
	
	public String loginErrorDisplayed(){
		getElement(LOGIN_ERROR);
		waitForElementToBeVisible(LOGIN_ERROR);
		return (getElementText(LOGIN_ERROR));
	}
	
	public KnowledgeFeedPage clickOnLoginButton(){
		getElement(LOGIN_BUTTON);
		waitForElementToBeClickable(LOGIN_BUTTON);
		click(LOGIN_BUTTON);
		return new KnowledgeFeedPage();
	}
	
	
}
