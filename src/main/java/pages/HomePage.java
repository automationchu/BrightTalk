package pages;

import org.openqa.selenium.By;

import enums.Url;
import utils.WebDriverUtils;

public class HomePage extends WebDriverUtils{
	
	private final By LOG_IN = By.linkText("Log in");
	
	

	public void navigateToHomePage(){
		navigateToURL(Url.BASE_URL.getUrl());
	}
	
	public LoginPage clickOnLoginButton(){
		getElement(LOG_IN);
		waitForElementToBeVisible(LOG_IN);
		waitForElementToBeClickable(LOG_IN);
		click(LOG_IN);
		return new LoginPage();
	}
}
