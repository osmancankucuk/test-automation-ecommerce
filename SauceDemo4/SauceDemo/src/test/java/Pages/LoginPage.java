package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class LoginPage {
    WebDriver driver;
    Util.ElementHelper elementHelper;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }

    By productText=By.cssSelector(".product_label");


    public void exceptCookies(String secim, String cookieAccept, String cookieReject){
        By cookieAcceptButton = By.xpath(cookieAccept);
        By cookieRejectButton = By.xpath(cookieReject);

        if (secim.equalsIgnoreCase("e")) { driver.findElement(cookieAcceptButton).click(); }

        else {driver.findElement(cookieRejectButton).click();}
    }

    public void userAtHomePage(String website) { driver.get(website); }

    public void hoverElement(String loginHoverButton) {
        WebElement loginHoverButtonElement = driver.findElement(By.xpath(loginHoverButton));

        elementHelper.hover(loginHoverButtonElement);
    }

    public void clickButton(String loginButton) {
        By loginButtonElement = By.xpath(loginButton);

        driver.findElement(loginButtonElement).click();
    }

    public void checkMessage(String message) {
        By errorMessage=By.xpath(message);
        elementHelper.checkVisible(errorMessage);
    }

    public void writeUsernameforUsernameField(String userNameElement, String userName) {
        By usernameBox=By.xpath(userNameElement);

        elementHelper.sendKey(usernameBox,userName);
    }

    public void writePasswordForPasswordField(String passwordElement, String password) {
        By passwordBox=By.xpath(passwordElement);

        elementHelper.sendKey(passwordBox,password);
    }

    public void sendKeysButton(String sendKeysElementPath, String sendKeysValue){
        By sendKeysElement = By.xpath(sendKeysElementPath);
        elementHelper.sendKey(sendKeysElement, sendKeysValue);
    }

    public void pageDown(){ elementHelper.pageDown(); }

    public void switchToNewTab() {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Find the new tab handle by excluding the current handle
        String currentHandle = driver.getWindowHandle();
        String newTabHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                newTabHandle = handle;
                break;
            }
        }

        // Switch to the new tab
        if (newTabHandle != null) {
            driver.switchTo().window(newTabHandle);
        } else {
            throw new NoSuchElementException("New tab not found!");
        }
    }

    public void amazonSendKeys(String sendKeysElementPath, String sendKeysValue){
        By sendKeysElement = By.xpath(sendKeysElementPath);
        elementHelper.amazonSendKeys(sendKeysElement, sendKeysValue);
    }


//    public void correctUsernameForUsernameField(String correctUsername) {
//        driver.findElement(usernameBox).click();
//        elementHelper.sendKey(usernameBox,"standard_user");
//
//    }
//
//    public void falsePasswordForPasswordField(String falsePassword) {
//        driver.findElement(passwordBox).click();
//        elementHelper.sendKey(passwordBox,"abc1234");
//    }
//
//    public void dontMatchErrorMessage(String dontMatch) {
//        elementHelper.checkVisible(errorMessage);
//    }
//
//    public void checkSuccesful() {
//        elementHelper.checkVisible(productText);
//    }
//
//    public void writeCorrectPassword(String correctPassword) {
//        driver.findElement(passwordBox).click();
//        elementHelper.sendKey(passwordBox,"secret_sauce");
//    }
}
