package project.tests;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import project.pages.homePage;
import project.pages.resultPage;

import static java.lang.Thread.sleep;

public class resultTest {
    public static void main(String[] args) throws InterruptedException {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.nike.com/us");

        homePage homePage = new homePage(driver);
        homePage.searchValue("air jordan 5");
        sleep(5000);


        resultPage resultPage = new resultPage(driver);
        String firstResult = resultPage.getFirstItem();
        Assert.assertTrue(firstResult.contains("air jordan 5"));

        base.seleniumClose(driver);
    }
}
