package project.tests;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import project.pages.homePage;
import project.pages.shoesPage;
//import project.pages.sortInShoesPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class sortShoesTest {
    public static void main(String[] args) throws InterruptedException {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.nike.com/us");

        homePage homePage = new homePage(driver);
        homePage.closeLocationChoice();
        homePage.hoverOverMenLink();
        homePage.chooseCategory();

        shoesPage shoesPage = new shoesPage(driver);
        shoesPage.setSort();
        List<Float> sortedPrices = shoesPage.getSortedPricesDesc();

        for (int i = 0; i < sortedPrices.size() - 1; i++) {
            Assert.assertTrue("The prices is not sorted", sortedPrices.get(i) >= sortedPrices.get(i + 1));
        }


        sleep(3500);
        base.seleniumClose(driver);
    }
}
