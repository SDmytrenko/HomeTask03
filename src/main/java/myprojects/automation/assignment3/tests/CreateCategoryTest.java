package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        WebDriver driver = getConfiguredDriver();
        GeneralActions a = new GeneralActions(driver);
        String login = "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";

       a.login(login, password);
       String catName = "Household";
       a.createCategory(catName);
        WebElement catalog = driver.findElement(By.xpath("//*[@id=\"subtab-AdminCatalog\"]/a"));
        WebElement categories = driver.findElement(By.cssSelector("#subtab-AdminCategories > a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(catalog).click(categories).build().perform();

        WebElement filterByName = driver.findElement(By.name("categoryFilter_name"));
        filterByName.sendKeys(catName);
        filterByName.submit();

        By record = By.xpath("//tbody/tr/td[contains(text(), \"Household\")]");
        a.waitForContentLoad(record);




        // ...

        // login

        // create category

        // check that new category appears in Categories table

        // finish script
    }
}
