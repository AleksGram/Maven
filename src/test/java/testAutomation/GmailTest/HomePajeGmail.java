package testAutomation.GmailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePajeGmail {
    String email = "test";
    String passwd = "test";
    WebDriver driver;
    @FindBy(id = "Email")
    @CacheLookup
    WebElement emailField;
    @FindBy(id = "next")
    @CacheLookup
    WebElement nextBtn;
    @FindBy(id = "PersistentCookie")
    @CacheLookup
    WebElement staySigned;
    @FindBy(id = "Passwd")
    @CacheLookup
    WebElement passwdField;
    @FindBy(id = "signIn")
    @CacheLookup
    WebElement signInBtn;

    public HomePajeGmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmailFild() {
        emailField.sendKeys(email);
    }

    public void clickNext() {
        nextBtn.click();
    }

    public void deactiveStaySigned() {
        staySigned.click();
    }

    public void fillPasswdField() {
        passwdField.sendKeys(passwd);
    }

    public void clickSignIn() {
        signInBtn.click();
    }
}
