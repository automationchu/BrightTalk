package pages;

import org.openqa.selenium.By;

import utils.WebDriverUtils;

public class EditProfilePage extends WebDriverUtils{

	private final By LAST_NAME = By.id("edit-field2");
	private final By SAVE_CHANGES = By.id("edit-submit-editprofile");
	private final By DELETE_MY_PROFILE = By.partialLinkText("Delete me from BrightTALK");
	
	public void changeLastName(String lastName){
		clearField(getElement(LAST_NAME));
		sendKeys(LAST_NAME, lastName);
	}
	
	public ProfilePage clickOnSaveChanges(){
		click(SAVE_CHANGES);
		return new ProfilePage();
	}
	
	public DeleteMePage deleteMyProfile(){
		getElement(DELETE_MY_PROFILE);
		click(DELETE_MY_PROFILE);
		return new DeleteMePage();
	}
	
	
}
