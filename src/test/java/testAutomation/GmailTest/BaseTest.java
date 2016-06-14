package testAutomation.GmailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    HomePajeGmail homePajeGmail;
    GmailPaje gmailPaje;
    protected static String baseUrl = "https://mail.google.com";

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePajeGmail = new HomePajeGmail(driver);
        gmailPaje = new GmailPaje(driver);
        homePajeGmail.fillEmailFild();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePajeGmail.clickNext();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePajeGmail.deactiveStaySigned();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePajeGmail.fillPasswdField();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePajeGmail.clickSignIn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void quit(){
        driver.quit();


    }
}
