package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *  3. Write down the following test into ‘LoginTest’ class
 *  * 1. userSholdLoginSuccessfullyWithValid Credentials
 *  * * Enter “standard_user” username
 *  * * Enter “secret_sauce” password
 *  * * Click on ‘LOGIN’ button
 *  * * Verify the text “PRODUCTS”
 *  * 2. verifyThatSixProductsAreDisplayedOnPage
 *  * * Enter “standard_user” username
 *  * * Enter “secret_sauce” password
 *  * * Click on ‘LOGIN’ button
 *  * * Verify that six products are displayed on page
 */
public class LoginTest extends BaseTest {
    //BaseUrl
    String baseUrl = "https://www.saucedemo.com/";

    //calling openBrowser method from parentclass BaseTest
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    //*  * 1. userSholdLoginSuccessfullyWithValid Credentials
    // * * Enter “standard_user” username
    // * * Enter “secret_sauce” password
    // * * Click on ‘LOGIN’ button
    // *  * * Verify the text “PRODUCTS”
    @Test
    public void usershouldLoginSuccessfullyWithValidCredentials(){

        // * * Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // * * Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // * * Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        // * * Verify the text “PRODUCTS”
        String expectedmessage = "Products";
        String actualmessage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals("User is unable to navigate to Products page", expectedmessage, actualmessage);
    }

    // *  * 2. verifyThatSixProductsAreDisplayedOnPage
    // * * Enter “standard_user” username
    // * * Enter “secret_sauce” password
    //* * Click on ‘LOGIN’ button
    // * * Verify that six products are displayed on page

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // * * Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // * * Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // * * Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        // * * Verify that six products are displayed on page

        List<WebElement> productelement = driver.findElements(By.className("inventory_item"));
        int expectedProducts = 6;
        Assert.assertEquals("User cannot see six products.", expectedProducts, productelement.size());

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
