package pages;

import org.openqa.selenium.By;

import utils.WebDriverUtils;

public class ProfilePage extends WebDriverUtils{

	private final By PROFILE = By.xpath("//*[@style='display: block;']");
	private final By LOG_OUT = By.linkText("Log out");
	private final By RETURN_TO_MY_PROFILE = By.linkText("Return to My BrightTALK");
	
	
	public void clickOnProfile(){
		getElement(PROFILE);
		waitForElementToBeVisible(PROFILE);
		waitForElementToBeClickable(PROFILE);
		click(PROFILE);
	}
	
	public void clickReturnToUserProfile(){
		getElement(RETURN_TO_MY_PROFILE);
		waitForElementToBeVisible(RETURN_TO_MY_PROFILE);
		waitForElementToBeClickable(RETURN_TO_MY_PROFILE);
		click(RETURN_TO_MY_PROFILE);
	}
	
	public void signOut(){
		getElement(LOG_OUT);
		waitForElementToBeVisible(LOG_OUT);
		waitForElementToBeClickable(LOG_OUT);
		click(LOG_OUT);
	}
}
