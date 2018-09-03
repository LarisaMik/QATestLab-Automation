package presta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;

public class WebDriverLogger extends AbstractWebDriverEventListener {
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigating to " +url);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Change value of the field " + element.toString() + " value: " + Arrays.toString(keysToSend));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Before click on element " +element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("After click on element " +element);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("After find an element " +by);
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to " +url);
    }


}
