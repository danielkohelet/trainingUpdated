package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class resultPage {
    private ChromeDriver driver;

    @FindBy(css = "a[data-testid='product-card__link-overlay']")
    WebElement resultName;

    public resultPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstItem() {
        return resultName.getText();
    }
}
