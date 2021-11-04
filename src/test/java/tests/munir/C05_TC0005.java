package tests.munir;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0004QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C05_TC0005 extends TestBaseRapor {

    // TC_0005_US_0004 Add hotel sayfasındaki Box'ların doldurulabilmesi (NT 3)

    @Test
    public void test5() {
        extentTest = extentReports.createTest("Siteye giriş ve otel ekleme (NT 3).");

        US_0004QAConcortPage us_0004QAConcortPage = new US_0004QAConcortPage();
        us_0004QAConcortPage.ConcortHotelLogin();
        extentTest.info("Siteye gidildi ve giriş yapıldı");

        ReusableMethods.waitFor(2);
        us_0004QAConcortPage.hotelManagement.click();
        us_0004QAConcortPage.hotelList.click();
        us_0004QAConcortPage.addHotelButonu.click();
        extentTest.info("Sırasıyla Hotel Management, Hotel list butonları tıklandı.");

        Actions actions = new Actions(Driver.getDriver());


        actions.click(us_0004QAConcortPage.codeTextBox)
                .sendKeys(ConfigReader.getProperty("Codebox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Namebox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Addressbox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Phonebox"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
        extentTest.info("Email textbox'ı hariç tüm textbox'lar sırasıyla dolduruldu");

        us_0004QAConcortPage.saveButonu.click();
        extentTest.info("Save butonuna tıklandı");

        Assert.assertTrue(us_0004QAConcortPage.emailError.isDisplayed());
        extentTest.pass("Email textbox'ı girilmediğinde otel eklenmedi ve 'Email' yazısı görüldü");

        Driver.closeDriver();
    }
}