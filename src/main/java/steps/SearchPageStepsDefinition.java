package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MercadoLibreHomePage;
import pages.SearchResultsPage;

import java.util.List;

public class SearchPageStepsDefinition {
    private WebDriver driver = Hooks.driver;
    private MercadoLibreHomePage mercadoLibreHomePage;
    private SearchResultsPage searchResultsPage;


    @Given("I navigate to the MercadoLibre search page")
    public void iNavigateToTheMercadoLibreSearchPage() {
        driver.get("https://www.mercadolibre.com.ar/");
        mercadoLibreHomePage = new MercadoLibreHomePage(driver);
    }

    @When("I search {string} in the search bar")
    public void iEnterInTheSearchBar(String product) {
        searchResultsPage = mercadoLibreHomePage.searchProduct(product);
    }

    @Then("I get the results from the first <{int}> pages")
    public void iGetTheResultsFromTheFirstPages(int totalPages) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            List<WebElement> productTitles = searchResultsPage.getProductsTitles();
            List<WebElement> productPrices = searchResultsPage.getProductsPrices();
            List<WebElement> productsLinks = searchResultsPage.getProductsLinks();
            System.out.println("--------------- PAGE NUMBER: " + (i+1) + " ---------------");
            for (int j = 0; j < productTitles.size(); j++) {
                System.out.println((j+1) +") PRODUCT: " + productTitles.get(j).getText()
                        + "| PRICE: " + productPrices.get(j).getText()
                        + "| URL: " + productsLinks.get(j).getAttribute("href"));
            }
            searchResultsPage.clickNextPageButton();
        }
    }
}
