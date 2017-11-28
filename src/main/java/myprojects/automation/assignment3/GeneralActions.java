package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private static WebDriver driver;
    private WebDriverWait wait;


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {

        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("passwd")).submit();
        // TODO implement logging in to Admin Panel
        // throw new UnsupportedOperationException();
    }

    /**
     * Adds new category in Admin Panel.
     * //* @param categoryName
     */
    public void createCategory(String categoryName) {
        WebElement catalog = driver.findElement(By.xpath("//*[@id=\"subtab-AdminCatalog\"]/a"));
        WebElement categories = driver.findElement(By.cssSelector("#subtab-AdminCategories > a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(catalog).click(categories).build().perform();
        WebElement createCat = driver.findElement(By.xpath("//*[@id=\"page-header-desc-category-new_category\"]"));
        createCat.click();
        WebElement catName = driver.findElement(By.id("name_1"));
        catName.sendKeys(categoryName);
        catName.submit();
        // TODO implement logic for new category creation
        //throw new UnsupportedOperationException();

    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
