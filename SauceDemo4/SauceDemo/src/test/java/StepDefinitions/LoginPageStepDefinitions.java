package StepDefinitions;


import Pages.LoginPage;
import Util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageStepDefinitions {

    WebDriver driver    = DriverFactory.getDriver();

    LoginPage loginPage = new LoginPage(driver);

    Actions action=new Actions(driver);

    @Given("User at HomePage {string}")
    public void userAtHomePage(String website) { loginPage.userAtHomePage(website); }

    @And("Except Cookies {string} {string}")
    public void exceptCookies(String cookieAccept, String cookieReject)
    { loginPage.exceptCookies("h", cookieAccept, cookieReject); }

    @And("Click login Hover button {string}")
    public void clickLoginHoverButton(String loginHoverButton) { loginPage.hoverElement(loginHoverButton); }

    @And("Click login button {string}")
    public void clickLoginButton(String loginButton) throws InterruptedException {
        Thread.sleep(1000);
        loginPage.clickButton(loginButton);
    }

    @And("write Correct {string} and {string} for username field")
    public void writeCorrectAndForUsernameField(String userNameElement, String userName)
    { loginPage.writeUsernameforUsernameField(userNameElement, userName); }

    @And("write false {string} and {string} for password field")
    public void writeFalseAndForPasswordField(String passwordElement, String password)
    { loginPage.writePasswordForPasswordField(passwordElement, password); }

    @And("Select Input Button {string} {string} and Click Search Button {string}")
    public void selectInputButtonAndClickSearchButton(String selectInputButtonPath, String inputMessage, String searchButtonPath) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        loginPage.clickButton(searchButtonPath);
        loginPage.sendKeysButton(selectInputButtonPath, inputMessage);
        loginPage.clickButton(searchButtonPath);
    }

    @And("Click Shipped by Amazon")
    public void clickShippedByAmazon() // Just Amazon
    { loginPage.clickButton("//li[@id='p_98/21345978031']//i[@class='a-icon a-icon-checkbox']"); }

    @And("Choose Apple {string}")
    public void chooseApple(String chooseButtonPath) { loginPage.clickButton(chooseButtonPath); }

    @And("Click to Product {string}")
    public void clickToProduct(String productPath) { loginPage.clickButton(productPath); }

    @And("Add {string} and Go to Cart {string}")
    public void addAndGoToCart(String addToCartButtonPath, String goToCartButtonPath) {

        loginPage.clickButton(addToCartButtonPath);
        loginPage.clickButton(goToCartButtonPath);

    }

    @And("Click to Understand Button")
    public void clickToUnderstandButton() { loginPage.clickButton("//button[contains(text(),'Anladım')]"); }

    @And("Complete Cart {string}")
    public void andEmptyTheBasket(String completeCartButtonPath) { loginPage.clickButton(completeCartButtonPath); }

    @Then("Check {string} error message")
    public void checkErrorMessage(String error) { loginPage.checkMessage(error); }

    @And("Add {string} and Go to the Cart {string}") // Just Trendyol
    public void addAndGoToTheCart(String addToCartButtonPath, String goToCartButtonPath) {
        loginPage.switchToNewTab();
        loginPage.clickButton(addToCartButtonPath);
        loginPage.clickButton(goToCartButtonPath);
    }

    @And("Fill {string} the Name and Surname {string}") // JUST AMAZON
    public void fillTheNameAndSurname(String nameAndSurnamePath, String nameAndSurname) {
        loginPage.sendKeysButton(nameAndSurnamePath, nameAndSurname);
    }

    @And("Fill {string} the Telephone Number {string}")
    public void fillTheTelephoneNumber(String telephoneNumberPath, String telephoneNumber) {
        loginPage.sendKeysButton(telephoneNumberPath, telephoneNumber);
    }

    @And("Empty the Basket {string}")
    public void emptyTheBasket(String arg0) {
    }

    @And("Fill the Address")
    public void fillTheOpenAddress() {
        loginPage.sendKeysButton("//input[@id='address-ui-widgets-enterAddressLine1']", "Aydınevler Mahallesi İnönü Caddesi");
        loginPage.sendKeysButton("//input[@id='address-ui-widgets-enterAddressLine2']", "No:20 Küçükyalı Ofispark B Blok");
    }

    @And("Fill the City, District, Neighbourhood") // JUST AMAZON
    public void fillTheCityDistrictNeighbourhood() {
        WebElement cityInput = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']"));
         // Replace "Your City Name" with the desired city name
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='suggestion-list']")));
        cityInput.sendKeys("Istan");

        Actions actions = new Actions(driver);
        actions.moveToElement(cityInput).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

//        String city = "Istan";
//        String script = "arguments[0].value='" + city + "';"; // Set the value using JavaScript
//        ((JavascriptExecutor) driver).executeScript(script, cityInput);
//        cityInput.sendKeys(Keys.ARROW_DOWN);
//        cityInput.sendKeys(Keys.ENTER);

//        try {
//            Thread.sleep(1000); // Adjust the wait time as needed (1 second in this case)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        cityInput.sendKeys(Keys.ENTER);

//        loginPage.amazonSendKeys("//input[@id='address-ui-widgets-enterAddressCity']", "İstanbul");
//        jsExecutor.executeScript("arguments[0].value = arguments[1];", "//input[@id='address-ui-widgets-enterAddressCity']", "Istanbul");

//        loginPage.clickButton("//input[@id='address-ui-widgets-enterAddressStateOrRegion']");
//        loginPage.amazonSendKeys("//input[@id='address-ui-widgets-enterAddressStateOrRegion']","Kucukcekmece");
//        loginPage.clickButton("//input[@id='address-ui-widgets-enterAddressStateOrRegion']");
//        loginPage.clickButton("//input[@id='address-ui-widgets-enterAddressStateOrRegion']");
//        loginPage.amazonSendKeys("//input[@id='address-ui-widgets-enterAddressStateOrRegion']", "Ümraniye");
//
//        loginPage.clickButton("//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']");
//        loginPage.sendKeysButton("//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']", "Altınşehir Mh.");
    }

    @And("District")
    public void district() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.amazonSendKeys("//input[@id='address-ui-widgets-enterAddressStateOrRegion']","Umraniye");
    }


//    @Then("Check {string} message about username")
//    public void checkMessageAboutUsername(String username) { loginPage.checkMessage(username); }
//
//    @When("write {string} for username field")
//    public void writeForUsernameField(String Username) { loginPage.writeUsernameforUsernameField(Username); }
//
//    @Then("Check {string} message about password")
//    public void checkMessageAboutPassword(String error) { loginPage.checkMessage(error); }
//
//    @When("write {string} for password field")
//    public void writeForPasswordField(String password) { loginPage.writePasswordForPasswordField(password); }
//
//    @When("write Correct {string} for username field")
//    public void writeCorrectForUsernameField(String correctUsername) { loginPage.correctUsernameForUsernameField(correctUsername); }
//
//    @When("write false {string} for password field")
//    public void writeFalseForPasswordField(String falsePassword) { loginPage.falsePasswordForPasswordField(falsePassword); }
//
//    @Then("Check {string} message about don't match")
//    public void checkMessageAboutDonTMatch(String dontMatch) { loginPage.dontMatchErrorMessage(dontMatch); }
//
//    @When("write Correct {string} for password field")
//    public void writeCorrectForPasswordField(String correctPassword) { loginPage.writeCorrectPassword(correctPassword); }
//
//    @Then("Check succesfull")
//    public void checkSuccesfull() { loginPage.checkSuccesful(); }
}