package tests.cigdem;

import org.testng.annotations.Test;
import pages.US_0003_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0003_TC_0002 extends TestBaseRapor {
    US_0003_QAConcortPage qaConcortPage3=new US_0003_QAConcortPage();
    @Test
    public void  positiveLoginTest(){
        //Log in butonuna tıklayın
        Driver.getDriver().get((ConfigReader.getProperty("CHQAUrl")));
        qaConcortPage3.firstlogIn.click();

        qaConcortPage3.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage3.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        //Log in sayfasında "Create a new account"butonuna tıklayın
        qaConcortPage3.Createanewaccount.click();


        //"Create a new account"butonuna tıkladığında "Registration Formu"görmeli
        qaConcortPage3.RegistrationForm.click();

        extentTest=extentReports.createTest("Create a new account butonuna tıkladığında Registration Formu görme testi");



    }


}


