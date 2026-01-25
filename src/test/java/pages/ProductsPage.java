package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By productsTitle = By.className("title");

    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).isDisplayed(); 
    }

}
