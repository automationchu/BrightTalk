package pages;

import org.openqa.selenium.By;
import utils.WebDriverUtils;

public class DeleteMePage extends WebDriverUtils{

	private final By DELETE_PROFILE = By.xpath("//input[@value='Delete Me']");
	private final By CONFIRMATION_BOX = By.xpath("//div[@id='confirmationDialog']");
	private final By YES_BUTTON = By.xpath("//div[@class='ui-dialog-buttonset']/button[1]");
	private final By NO_BUTTON = By.xpath("//div[@class='ui-dialog-buttonset']/button[2]");
	
	public void clickOnDeleteButton(){
		getElement(DELETE_PROFILE);
		click(DELETE_PROFILE);
	}
	
	public void confirmDeletion(){
		waitForElementToBeVisible(CONFIRMATION_BOX);
		getElement(CONFIRMATION_BOX);
	}
	
	public HomePage clickYes(){
		getElement(YES_BUTTON);
		waitForElementToBeClickable(YES_BUTTON);
		click(YES_BUTTON);
		return new HomePage();
	}
	
	public void clickNo(){
		getElement(NO_BUTTON);
		waitForElementToBeClickable(NO_BUTTON);
		click(NO_BUTTON);
	}
}
