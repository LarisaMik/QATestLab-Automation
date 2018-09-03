package presta;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


public class Lesson03 {
    public static void main(String[] args) {
        test();
    }

@Test
    public static void test (){
    EventFiringWebDriver driver = TestUtils.getEventFiringWebDriver();
    TestUtils.connectLogger(driver);
    TestUtils.login(driver);
    TestUtils.pause(3);
    TestUtils.hoverElement(driver, "subtab-AdminCatalog");
    TestUtils.clickElement(driver, "subtab-AdminCategories");
    TestUtils.clickElement(driver, "page-header-desc-category-new_category");
    TestUtils.inputField(driver, "name_1", "Category1");
    TestUtils.clickElement(driver, "category_form_submit_btn");
    TestUtils.pause(3);
    if (!TestUtils.checkElementIsDisplayed(driver, "alert-success")){
        return;
    }
    TestUtils.inputField(driver, "categoryFilter_name", "Category1");
    TestUtils.clickElement(driver, "submitFilterButtoncategory");

}
}
