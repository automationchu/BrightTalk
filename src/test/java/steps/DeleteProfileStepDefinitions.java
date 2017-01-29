package steps;

import java.util.List;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DeleteMePage;
import pages.EditProfilePage;
import pages.HomePage;
import pages.KnowledgeFeedPage;
import pages.LoginPage;

public class DeleteProfileStepDefinitions {

	HomePage homePage;
	LoginPage loginPage;
	KnowledgeFeedPage knowledgeFeedPage;
	EditProfilePage editProfilePage;
	DeleteMePage deleteMePage;
	public String loginAttemptError = "Incorrect email or password, please try again.";
	
	@Given("^that the registered user goes to the BrightTalk HomePage$")
		public void userBrowsesToTheBrightTalkHomePage() throws Throwable{
		homePage = new HomePage();
    	homePage.navigateToHomePage();
	}
	@And("^that the user is registered on the BrightTalk website$")
	public void registeredUserLogin(DataTable table) throws Throwable {
    	loginPage = homePage.clickOnLoginButton();
    	List<List<String>> data = table.raw();
    	loginPage.enterEmail(data.get(1).get(0));
    	loginPage.enterPassword(data.get(1).get(1));
    	knowledgeFeedPage = loginPage.clickOnLoginButton();
    } 
	
		
	@When("^the user deletes said self from the user profile page$")
	public void deleteUserProfile() throws Throwable {
		knowledgeFeedPage.clickOnIcon();
		editProfilePage = knowledgeFeedPage.selectEditProfile();
		deleteMePage = editProfilePage.deleteMyProfile();
	    deleteMePage.clickOnDeleteButton();
	    homePage = deleteMePage.clickYes();
	}
	
	@When("^login to Bright Talk platform$")
	public void reloginToPlatform(DataTable table) throws Throwable {
		homePage.navigateToHomePage();
		loginPage = homePage.clickOnLoginButton();
		List<List<String>> data = table.raw();
		loginPage.enterEmail(data.get(1).get(0));
    	loginPage.enterPassword(data.get(1).get(1));
    	knowledgeFeedPage = loginPage.clickOnLoginButton();
    }
	
	@Then("^the user can not login to the BrightTalk platform$")
	public void verifyUserCannotLogBackOntoPlatform() throws Throwable {
	    Assert.assertEquals(loginAttemptError, loginPage.loginErrorDisplayed());
	    
	}
}
