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
import pages.ProfilePage;

public class ChangeLastNameStepDefinitions {

	HomePage homePage;
	LoginPage loginPage;
	KnowledgeFeedPage knowledgeFeedPage;
	EditProfilePage editProfilePage;
	ProfilePage profilePage; 
	DeleteMePage deleteMePage;
	public String changeLastName = "Megatron-XMEN";
		
	@Given("^the new user is registered to the www\\.brighttalk\\.com website$")
	public void registeredUserLogin(DataTable table) throws Throwable {
    	homePage = new HomePage();
    	homePage.navigateToHomePage();
    	loginPage = homePage.clickOnLoginButton();
    	List<List<String>> data = table.raw();
    	loginPage.enterEmail(data.get(1).get(0));
    	loginPage.enterPassword(data.get(1).get(1));
    	knowledgeFeedPage = loginPage.clickOnLoginButton();
    } 

	@When("^user selects the Edit Profile on the right top of the page$")
	public void selectEditProfile() throws Throwable {
	   knowledgeFeedPage.clickOnIcon();
	   editProfilePage = knowledgeFeedPage.selectEditProfile();
	}
   
	@And("^changes the \"([^\"]*)\" on the Profile page$")
	public void changeLastNameOnEditProfile(String LastName) throws Throwable {
		
		editProfilePage.changeLastName(changeLastName);
		profilePage = editProfilePage.clickOnSaveChanges();
		profilePage.clickReturnToUserProfile();
		knowledgeFeedPage.clickOnIcon();
		knowledgeFeedPage.clickOnLogout();
	}

	@And("^re-logins to the site$")
	public void loginToPlatform(DataTable table) throws Throwable {
		homePage = new HomePage();
		homePage.navigateToHomePage();
		loginPage = homePage.clickOnLoginButton();
		List<List<String>> data = table.raw();
		loginPage.enterEmail(data.get(1).get(0));
    	loginPage.enterPassword(data.get(1).get(1));
    	knowledgeFeedPage = loginPage.clickOnLoginButton();
    }

	@Then("^the new \"([^\"]*)\" is shown on the left side of the Knowledge feed page\\.$")
	public void verifyLastNameOnKnowledgeFeedPage(String lastName) throws Throwable {
		knowledgeFeedPage.checkLastName();
		Assert.assertTrue(knowledgeFeedPage.checkLastName().contains(changeLastName));
		knowledgeFeedPage.clickOnIcon();
		knowledgeFeedPage.clickOnLogout();
		
	} 
	
	
}
