package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MercadoLibreHomePage {

    private WebDriver driver;
    private By searchBar = By.cssSelector("#cb1-edit");
    private By acceptCookiesPopUp = By.xpath("//button[@class=\"cookie-consent-banner-opt-out__action cookie-consent-banner-opt-out__action--primary cookie-consent-banner-opt-out__action--key-accept\"]");


    public MercadoLibreHomePage(WebDriver driver) { this.driver = driver; }

    public SearchResultsPage searchProduct(String product){
        driver.findElement(acceptCookiesPopUp).click();
        driver.findElement(searchBar).sendKeys(product, Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
