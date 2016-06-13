package testAutomation;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


import static com.sun.xml.internal.ws.client.ContentNegotiation.none;
import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GmailTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
    /*File pathBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
    FirefoxBinary Binary= new FirefoxBinary(pathBinary);
    FirefoxProfile firefoxPro = new FirefoxProfile();
    driver = new FirefoxDriver(Binary, firefoxPro);*/
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com.ua/";
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @Test
    public void testGmail() {
        driver.get(baseUrl + "/?gfe_rd=cr&ei=GHxZV7r2FOKcwwO_yaOgDg&gws_rd=ssl");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("gmail.com");
        driver.findElement(By.cssSelector(".r> a")).click();
        driver.findElement(By.id("Email")).sendKeys("test");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("PersistentCookie")).click();
        driver.findElement(By.id("Passwd")).sendKeys("test");
        driver.findElement(By.id("signIn")).click();


        driver.findElement(By.id(":2t")).click();

        //Create an array of elements
        List<WebElement> listOfElements;
        listOfElements = driver.findElements(By.xpath("//div[@id=\":30\"]/*/div[@role=\"menuitem\"or\"menuitemcheckbox\"][@style=\"-moz-user-select: none;\"]"));


        for (WebElement element : listOfElements) {

            //Create actions of moving mouse over the elements
            Actions builder = new Actions(driver);
            builder.moveToElement(element);
            Action mouseOverElement = builder.build();
            mouseOverElement.perform();


            //Get a value of the background color
            System.out.println(element.getCssValue("background-color"));
            assertTrue(element.isDisplayed(), "Element doesn't present");
        }


        driver.findElement(By.cssSelector("a[title='Приложения Google']")).click();
        driver.findElement(By.cssSelector("a[aria-label=\"Ещё приложения Google\"]")).click();

        //Create array of Google-apps icons and get its names
        List<WebElement> listOfIcons;
        listOfIcons = driver.findElements(By.cssSelector(" li.gb_Z"));
        for (WebElement icon : listOfIcons) {
            System.out.println(icon.getText());
        }
        WebElement appsElement = driver.findElement(By.cssSelector("a[id='gb192']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(appsElement);
        Action overAppsElement = builder.build();
        overAppsElement.perform();
        System.out.println(appsElement.getCssValue("border-top-color"));


        //check the quantity of the mails
        driver.findElement(By.cssSelector("div.n6")).click();
        driver.findElement(By.cssSelector("a[title=\"Вся почта\"]")).click();
        Assert.assertEquals((driver.findElements(By.cssSelector("div[id=\":4\"] td[class=\"xY a4W\"]")).size()), 50);
        driver.findElement(By.cssSelector("img.amJ, T-I-J3")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Thread.sleep(2000);
    }

   @Test
    public void testLetterCount() {
       String valueAfterClicking = driver.findElement(By.cssSelector("span.Dj>b:nth-child(1)")).getAttribute("textContent");
       System.out.println(valueAfterClicking);
       // Assert.assertEquals(valueAfterClicking,"51");


       driver.findElement(By.cssSelector("a.wrap_label > div.text_label")).click();

   }



    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}

