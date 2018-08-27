package lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test A started");
        scenarioA();
        System.out.println("Test A finished");
        Thread.sleep(5000);
        System.out.println("Test B started");
        scenarioB();
        System.out.println("Test B finished");
    }

    private static void scenarioA() throws InterruptedException {
        WebDriver driver = getInitFirefoxdriver ();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys("webinar.test@gmail.com");
        WebElement fieldPassword = driver.findElement(By.id("passwd"));
        fieldPassword.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement buttonLogin = driver.findElement(By.name("submitLogin"));
        buttonLogin.click();

        Thread.sleep(5000);
        WebElement employeeInfos = driver.findElement(By.id("employee_infos"));
        employeeInfos.click();

        driver.findElement(By.id("header_logout")).click();
        Thread.sleep(1000);
        driver.close();
    }

    private static void scenarioB() {
        WebDriver driver = getInitFirefoxdriver();
        try {
            driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/  ");
            WebElement fieldEmail = driver.findElement(By.id("email"));
            fieldEmail.sendKeys("webinar.test@gmail.com");
            WebElement fieldPassword = driver.findElement(By.id("passwd"));
            fieldPassword.sendKeys("Xcg7299bnSmMuRLp9ITw");
            WebElement buttonLogin = driver.findElement(By.name("submitLogin"));
            buttonLogin.click();

            Thread.sleep(5000);

            changeTabs(driver, "tab-AdminDashboard");
            changeTabs(driver, "subtab-AdminParentOrders");
            changeTabs(driver, "subtab-AdminCatalog");
            changeTabs(driver, "li[data-submenu='23']");
            changeTabs(driver, "subtab-AdminParentCustomerThreads");
            changeTabs(driver, "subtab-AdminStats");
            changeTabs(driver, "subtab-AdminParentModulesSf");
            changeTabs(driver, "li[data-submenu='46']");
            changeTabs(driver, "subtab-AdminParentShipping");
            changeTabs(driver, "subtab-AdminParentPayment");
            changeTabs(driver, "subtab-AdminInternational");
            changeTabs (driver, "subtab-ShopParameters");
            changeTabs(driver, "subtab-AdminAdvancedParameters");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

    }

    private static WebDriver getInitFirefoxdriver (){
        System.setProperty("webdriver.gecko.driver", Solution.class.getResource("geckodriver.exe").getPath());

        return new FirefoxDriver();
    }

    private static void changeTabs(WebDriver driver, String elementId) throws InterruptedException {
        WebElement dashboard;
        try {
            dashboard = driver.findElement(By.id(elementId));
        } catch (NoSuchElementException e) {
            dashboard = driver.findElement(By.cssSelector(elementId));
        }
        dashboard.click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        Thread.sleep(500);
        String newUrl = driver.getCurrentUrl();

        System.out.println(currentUrl.equals(newUrl) ? "The same" : "Different URLs");
    }

}
