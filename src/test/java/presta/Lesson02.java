package presta;

import org.openqa.selenium.WebDriver;

public class Lesson02 {

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
        WebDriver driver = TestUtils.getInitFirefoxdriver ();

        TestUtils.login(driver);


        Thread.sleep(5000);
        TestUtils.logout(driver);
        Thread.sleep(1000);
        driver.close();
    }

    private static void scenarioB() {
        String[] tabNames = {"tab-AdminDashboard", "subtab-AdminParentOrders", "subtab-AdminCatalog", "li[data-submenu='23']",
                "subtab-AdminParentCustomerThreads", "subtab-AdminStats", "subtab-AdminParentModulesSf", "li[data-submenu='46']",
                "subtab-AdminParentShipping", "subtab-AdminParentPayment", "subtab-AdminInternational", "subtab-ShopParameters",
                "subtab-AdminAdvancedParameters"};
        WebDriver driver = TestUtils.getInitFirefoxdriver();
        try {
            TestUtils.login(driver);
            TestUtils.pause(5);
            for (String tabName : tabNames) {
                TestUtils.clickElement(driver, tabName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TestUtils.pause(3);
            driver.close();
        }

    }
}
