package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

public class LoginSteps {
	
	LoginPage loginPage;
	ProductsPage productsPage;
	
	@Given("User is on SauceDemo login page")
    public void user_on_login_page() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        loginPage = new LoginPage(DriverFactory.getDriver());
        productsPage = new ProductsPage(DriverFactory.getDriver());
    }

    @When("User logs in with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("Login should be {string}")
    public void verify_login(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(productsPage.isProductsPageDisplayed());
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
    }
    
    @When("User enters valid credentials")
    public void enter_credentials() {
    	loginPage.login("standard_user", "secret_sauc4e");
    }
    
    @Then("User should land on products page")
    public void verifyLogin() {
    	Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }
    
    @When("User enters invalid credentials")
    public void enter_invalid_credentials() {
    	loginPage.login("standard_user11", "secret_sauc4e");
    }
    
    @Then("Error message should be displayed")
    public void errorMessgae_displayed() {
    	Assert.assertTrue(loginPage.isErrorDisplayed());
    }
	

}
