package presta;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestUtils {
    public static WebDriver getInitFirefoxdriver (){
        System.setProperty("webdriver.gecko.driver", TestUtils.class.getResource("geckodriver.exe").getPath());

        return new FirefoxDriver();
    }
    public static void login (WebDriver driver) {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys("webinar.test@gmail.com");
        WebElement fieldPassword = driver.findElement(By.id("passwd"));
        fieldPassword.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement buttonLogin = driver.findElement(By.name("submitLogin"));
        buttonLogin.click();
    }
    public static void logout (WebDriver driver){
        WebElement employeeInfos = findElement(driver, "employee_infos");
        employeeInfos.click();

        findElement(driver, "header_logout").click();

    }
    public static void clickElement(WebDriver driver, String elementId) {
        WebElement element = findElement(driver, elementId);

        element.click();
        pause(1);
    }
    public static void pause(int duration) {
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void hoverElement(WebDriver driver, String elementID){
        Actions action = new Actions(driver) ;
        WebElement element = findElement(driver, elementID);
        action.moveToElement(element).build().perform();
        pause(2);


    }
    public static void inputField (WebDriver driver, String elementID, String value){
        WebElement input = findElement(driver, elementID);
        input.sendKeys(value);

    }
    public static boolean checkElementIsDisplayed (WebDriver driver, String elementID){
        WebElement element = findElement(driver, elementID);
        return element.isDisplayed();

    }
    public static void connectLogger (EventFiringWebDriver driver){
        WebDriverLogger handler = new WebDriverLogger();
        driver.register(handler);
    }

    public static WebElement findElement (WebDriver driver, String elementID) {
        return findElement(driver, elementID, 0);
    }

    private static WebElement findElement (WebDriver driver, String elementID, int count){
        By[] bies = {By.id(elementID), By.name(elementID), By.className(elementID), By.cssSelector(elementID)};
        WebElement element = null;
        try {
            element = driver.findElement(bies[count]);
        } catch (NoSuchElementException e) {
            count = count + 1;
            element = findElement(driver, elementID, count);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return element;
    }

    public static EventFiringWebDriver getEventFiringWebDriver() {
        return new EventFiringWebDriver(getInitFirefoxdriver());
    }
}
