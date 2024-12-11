package project.tests;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import project.pages.homePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class linkTest {
    public static void main(String[] args) throws InterruptedException {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.nike.com/us");

        homePage homePage = new homePage(driver);
        List<String> linksList = homePage.getLinkList();
        List<String> expectedLinksList = new ArrayList<>(Arrays.asList("New", "Men", "Women", "Kids", "Jordan", "Sale"));
        Assert.assertEquals("Links is not match",linksList,expectedLinksList);

        sleep(3000);
        base.seleniumClose(driver);
    }
}
