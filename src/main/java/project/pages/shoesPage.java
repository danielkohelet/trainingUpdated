package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class shoesPage {
    private ChromeDriver driver;
    @FindBy(id = "dropdown-btn")
    WebElement sortButton;

    //The # symbol indicates that we are looking for an element with an id, the  id = sort-options
    //The space after the id indicates that we are looking for internal elements inside the same  element, the element is a button
    @FindBy(css = "#sort-options button")
    List<WebElement> sortOptions;

    public shoesPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Float> getPrice() {
        List<Float> priceFloatList = new ArrayList<>();
        List<WebElement> priceList = driver.findElements(By.cssSelector(".product-price.us__styling.is--current-price.css-11s12ax"));

        for (int i = 0; i < 8; i++) {
            String priceString = priceList.get(i).getText().replace("$", "").trim();
            float floatPrice = Float.parseFloat(priceString);
            priceFloatList.add(floatPrice);
        }
        return priceFloatList;
    }

    public void setSort() throws InterruptedException {
        sortButton.click();
        sortOptions.get(2).click();
        sleep(5000);
    }

    public List<Float> getSortedPricesDesc() {
        List<Float> priceFloatList = new ArrayList<>();
        List<WebElement> priceList = driver.findElements(By.cssSelector(".product-price.us__styling.is--current-price.css-11s12ax"));

        for (int i = 0; i < 5; i++) {
            String priceString = priceList.get(i).getText().replace("$", "").trim();
            float floatPrice = Float.parseFloat(priceString);
            priceFloatList.add(floatPrice);
        }
        return priceFloatList;
    }
}
