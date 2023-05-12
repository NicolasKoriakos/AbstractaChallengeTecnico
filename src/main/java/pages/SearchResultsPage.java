package pages;

import org.openqa.selenium.*;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private By listOfProductsTitles = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']/li//h2[@class=\"ui-search-item__title shops__item-title\"]");
    private By listOfProductsLinks = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']/li//a[@class=\"ui-search-item__group__element shops__items-group-details ui-search-link\"]");
    private By listOfProductsPrices = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']/li//div[@class=\"ui-search-price ui-search-price--size-medium shops__price\"]/div[1]/span[1]/span[1]");
    private By nextBtn = By.xpath("//li[@class=\"andes-pagination__button andes-pagination__button--next shops__pagination-button\"]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductsTitles(){
        return driver.findElements(listOfProductsTitles);
    }

    public List<WebElement> getProductsPrices(){
        return driver.findElements(listOfProductsPrices);
    }

    public List<WebElement> getProductsLinks(){
        return driver.findElements(listOfProductsLinks);
    }

    public void clickNextPageButton(){
        driver.findElement(nextBtn).click();
    }
}

