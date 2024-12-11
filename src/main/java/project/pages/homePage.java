package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class homePage {
    private ChromeDriver driver;
    List<String> homePageLinkListText = new ArrayList<>();

    @FindBy(linkText = "Men")
    WebElement menLink;

    @FindBy(linkText = "All Shoes")
    WebElement allShoesLink;

    @FindBy(className = "close-btn-container")
    WebElement closeButton;

    @FindBy(id="nav-search-icon")
    WebElement search;

    public homePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getLinkList() {
        List<WebElement> liknsList = this.driver.findElements(By.cssSelector(".desktop-category li a"));
        List<String> pageLinkListText = new ArrayList<>();

        for (WebElement link : liknsList) {
            if (link.isDisplayed()) {
                pageLinkListText.add(link.getText().trim());
            }
        }
        return pageLinkListText;
    }


    public void closeLocationChoice() {
        closeButton.click();
    }

    public void hoverOverMenLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(menLink).perform();
    }

    public void chooseCategory() {
        allShoesLink.click();
    }

    public void searchValue(String value){
        search.sendKeys(value + Keys.ENTER);
    }
}
