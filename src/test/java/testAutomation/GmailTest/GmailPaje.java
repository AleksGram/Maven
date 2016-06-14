package testAutomation.GmailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class GmailPaje {
    WebDriver driver;

    @FindBy(xpath = "//div[@id=\":30\"]/*/div[@role=\"menuitem\"or\"menuitemcheckbox\"][@style=\"-moz-user-select: none;\"]")
    @CacheLookup
    public List<WebElement> listOfSetingsMenu;

    @FindBy(id = ":2t")
    @CacheLookup
    public WebElement settingButton;

    @FindBy(css = "a[title='Приложения Google']")
    @CacheLookup
    public WebElement appsButton;

    @FindBy(css = "a[aria-label=\"Ещё приложения Google\"]")
    public WebElement moreApps;

    @FindBy(css = "li.gb_Z")
    @CacheLookup
    public List<WebElement> arrayApps;

    @FindBy(css = "a[id^='gb']")
    public List<WebElement> borderOfApp;
    @FindBy(css="a[id='gb192']")
    public WebElement appBorder;

    @FindBy(css = "div.n6")
    public WebElement cutDownOfMailSection;

    @FindBy(css = "a[title=\'Вся почта\']")
    public WebElement allMailButton;

    @FindBy(css = "div[id=\":4\"] td[class=\"xY a4W\"]")
    public List<WebElement> maillsAray;

    @FindBy(css = "img.amJ, T-I-J3")
    public WebElement paginationButton;

    @FindBy(css = "span.Dj>b:nth-child(1)")
    public WebElement countOfLettersValue;

    public GmailPaje(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSettingMenu() {
        settingButton.click();
    }

    public List<WebElement> getListOfSetingsMenu(){
        return listOfSetingsMenu;
    }
    public String getBgrColorSettingMenu() {
        String bgrColor = null;
        for (WebElement element : listOfSetingsMenu) {
            Actions builder = new Actions(driver);
            builder.moveToElement(element);
            Action mouseOverElement = builder.build();
            mouseOverElement.perform();
            bgrColor = element.getCssValue("background-color");
        }
        return bgrColor;
    }

    public int sizeMenuSetings() {
        return listOfSetingsMenu.size();
    }

    public void elementsIsDisplayed() {
        for (WebElement element : listOfSetingsMenu) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void googleAppsMenu() {
        appsButton.click();
    }
    public List<WebElement> getArrayApps(){
        return arrayApps;
    }

    public void getHiddenApps() {
        moreApps.click();
    }

    public void getAppsName() {
        for (WebElement icon : arrayApps) {
            System.out.println(icon.getText());
        }
    }

    public List<WebElement> getBordersOfApps() {
        return borderOfApp;
    }
    public void clickMoreBtn(){
        cutDownOfMailSection.click();
    }
    public void clickAllMaills(){
        allMailButton.click();
    }
    public int countOfLetters(){
    return maillsAray.size();
    }
    public void clickPagination(){
        paginationButton.click();
    }
    public String getPaginationValue(){
        return countOfLettersValue.getAttribute("textContent");
    }
}


