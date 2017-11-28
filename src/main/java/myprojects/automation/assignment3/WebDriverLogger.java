package myprojects.automation.assignment3;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by girl-hamster on 28.11.2017.
 */
public class WebDriverLogger extends AbstractWebDriverEventListener{
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("The element will be clicked - " + element.getText());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        final StringBuilder sb = new StringBuilder(keysToSend.length);
        sb.append(keysToSend);
        System.out.println("Changed value to: " + sb.toString());

    }


}
