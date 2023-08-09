package Util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    public ElementHelper(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,10);
        this.action=new Actions(driver);

    }
    public WebElement presenceElement(By key){
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement (By key){
        WebElement element=presenceElement(key);

        return element;
    }
    public void click(By key) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(key));
        findElement(key).click();
    }

    public void sendKey(By key,String text){ findElement(key).sendKeys(text); }

    public void checkVisible(By key){
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    public void pageDown(){ action.sendKeys(Keys.PAGE_DOWN).build().perform(); }

    public void hover(WebElement element){action.moveToElement(element).perform();}

    public void amazonSendKeys(By key, String text){




        WebElement elementToFill = wait.until(ExpectedConditions.visibilityOfElementLocated(key));
        elementToFill.sendKeys(text);

        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='address-ui-widgets-enterAddressStateOrRegion']")));
        elementToClick.click();

//
//        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(key));
//        elementToClick.click();

    }
}
