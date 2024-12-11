package project.tests;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import project.pages.homePage;
import project.pages.shoesPage;

import java.util.List;

public class shoesPriceTest {
    public static void main(String[] args) {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.nike.com/us");

        homePage homePage = new homePage(driver);
        homePage.closeLocationChoice ();
        homePage.hoverOverMenLink();
        homePage.chooseCategory  ();

        shoesPage shoesPage = new shoesPage(driver);
        List<Float> priceList = shoesPage.getPrice();
//        System.out.println("sss"+priceList);
        for (int i = 0; i < priceList.size(); i++) {
            Assert.assertTrue("The price is too low",priceList.get(i) >= 100);
        }
        base.seleniumClose(driver);
    }
}

