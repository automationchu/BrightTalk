package pages;

import org.openqa.selenium.By;

import utils.WebDriverUtils;

public class KnowledgeFeedPage extends WebDriverUtils{

	private final By PROFILE_ICON = By.xpath("//img[@class='profile-area-user-image ng-scope']");
	//private final By P_ICON = By.xpath("//button[@class='js-profile-menu-toggle-button profile-menu-toggle-button desktop-profile-menu-toggle-button profile-menu-close-button']/img");
	private final By EDIT_PROFILE = By.xpath("//nav[@class='profile-menu desktop-profile-menu hidden-xs']/ul/li[8]");
	private final By LOGOUT = By.xpath("//nav[@class='profile-menu desktop-profile-menu hidden-xs']/ul/li[9]");
	private final By PROFILE_NAME = By.xpath("//li[@class='profile-card-detail profile-card-name']");
	
	
	public void clickOnIcon(){
		getElement(PROFILE_ICON);
		waitForElementToBeVisible(PROFILE_ICON);
		waitForElementToBeClickable(PROFILE_ICON);
		click(PROFILE_ICON);
	}
	
	public EditProfilePage selectEditProfile(){
		getElement(EDIT_PROFILE);
		waitForElementToBeVisible(EDIT_PROFILE);
		waitForElementToBeClickable(EDIT_PROFILE);
		click(EDIT_PROFILE);
		return new EditProfilePage();
	}
	
	public void clickOnLogout(){
		getElement(LOGOUT);
		waitForElementToBeVisible(LOGOUT);
		waitForElementToBeClickable(LOGOUT);
		click(LOGOUT);
	}
	
	public String checkLastName(){
		getElement(PROFILE_NAME);
		return (getElementText(PROFILE_NAME));
	}
}
