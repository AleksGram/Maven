package testAutomation.GmailTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestGmailPaje extends BaseTest {
    @Test(description = "Elements Of Menu Setting is Visible")
    public void elementsOfSettingsMenuIsVisible() {
        gmailPaje.clickSettingMenu();
        for (WebElement element : gmailPaje.getListOfSetingsMenu()) {
            Assert.assertTrue(element.isDisplayed(), "Elements is not diplayed");
        }
    }
    @Test(description = "Elements Change Bgrd Color")
    public void elementsChangeBgrdColor(){
        gmailPaje.clickSettingMenu();
        gmailPaje.getListOfSetingsMenu();
        String bgrdColor=gmailPaje.getBgrColorSettingMenu();
        String requiredColor="rgba(238, 238, 238, 1)";
        System.out.println(bgrdColor+" "+requiredColor);
        Assert.assertEquals(bgrdColor,requiredColor, "Background color is not displayed");
    }
    @Test(description = "Apps Icons Is Displayed")
    public void appsIconsIsDisplayed(){
        gmailPaje.googleAppsMenu();
        gmailPaje.getHiddenApps();
        for(WebElement apps: gmailPaje.getArrayApps()){
            Assert.assertTrue(apps.isDisplayed());
        }
        System.out.println("Names of icons: ");
        gmailPaje.getAppsName();

    }
    @Test(description = "Check Border Color")
    public void checkBorderColor(){
        gmailPaje.googleAppsMenu();
        System.out.println(gmailPaje.appBorder.getCssValue("border-top-color"));
       for(WebElement apps: gmailPaje.getBordersOfApps()){
      //Assert.assertEquals(apps.getCssValue("border-top-color"),"rgba(229, 229, 229, 1)","Border color is false");
        }
    }
    @Test(description = "Count Of Letters")
    public void countOfLetters(){
        gmailPaje.clickMoreBtn();
        gmailPaje.clickAllMaills();
        Assert.assertEquals(gmailPaje.countOfLetters(),50);
    }
    @Test(description = "Check Pagination Of Letters")
    public void checkPaginationOfLetter(){
        gmailPaje.clickMoreBtn();
        gmailPaje.clickAllMaills();
        gmailPaje.clickPagination();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(gmailPaje.getPaginationValue());
    }
}
