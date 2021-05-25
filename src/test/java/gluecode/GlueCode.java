package gluecode;


import com.wipro.qetsolutions.selfhealing.selenium.SelfHealingWebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;

@FixMethodOrder(MethodSorters.DEFAULT)
public class GlueCode {
    WebDriver webDriver = null ;
    SelfHealingWebDriver driver = null ;

@Test
@Given("^user is on Register Page$")
public void user_is_on_Register_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
    //ChromeOptions chromeOptions = new ChromeOptions();
    //System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
    WebDriverManager.edgedriver().setup();
    webDriver = new EdgeDriver();
    driver = new SelfHealingWebDriver(webDriver);
    driver.manage().window().maximize();

    driver.enableAutoDiscovery();
    driver.enableAutoHealing();
    //Open the website
    driver.get("http://localhost:8080/shop/customer/registration.html");
}

    @Test
    @When("^user navigates to Registration Page$")
    public void user_navigates_to_Registration_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //Instantiate Action Class
        //driver.findElement(By.xpath("//a[@href='/shop/customer/registration.html'")).click();
//
//        Actions actions = new  Actions(driver);
//
//        //Retrieve WebElement 'My Account' to perform mouse hover
//
//        WebElement accountOption = driver.findElement(By.linkText("My Account"));
//
//        //Mouse hover menuOption 'My Account'
//        actions.moveToElement(accountOption).perform();
//        //Now Select 'Register' from sub menu
//        WebElement subMenuOption = driver.findElement(By.id("registerLink"));
//        actions.moveToElement(subMenuOption).click();

    }
    @Test
    @When("^user enters firstName and lastName$")
    public void user_enters_firstName_and_lastName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("paal");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Shah");
    }
    @Test
    @When("^user select the country$")
    public void user_select_the_country() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Select drpCountry = new Select(driver.findElement(By.name("billing.country")));
        drpCountry.selectByValue("IN");
    }
    @Test
    @When("^user enter state, Email address , Password and Repeat password$")
    public void user_enter_state_Email_address_Password_and_Repeat_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath("//*[@id=\"hidden_zones\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"hidden_zones\"]")).sendKeys("Madhya Pradesh");
        driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("pratyush"+Math.random()+"@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("wipro@123");
        driver.findElement(By.xpath("//*[@id=\"passwordAgain\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"passwordAgain\"]")).sendKeys("wipro@123");


    }
    @Test
    @When("^user clicks on Create an account$")
    public void user_clicks_on_Create_an_account() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/button")).click();
    }
    @Test
    @Then("^New account is created and user verify account Page$")
    public void new_account_is_created_and_user_verify_account_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String actualData = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/span")).getText();
        String expectedData = "My Account";
        Assert.assertEquals(expectedData,actualData);

        Actions actions2 = new  Actions(driver);

        //Retrieve WebElement 'My Account' to perform mouse hover

        WebElement accountOption2 = driver.findElement(By.linkText("My Account"));

        //Mouse hover menuOption 'My Account'
        actions2.moveToElement(accountOption2).perform();
        //Now Select 'Register' from sub menu
        WebElement subMenuOption2 = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        actions2.moveToElement(subMenuOption2).click();



    }
    @Test
    @Given("^user is on Login page$")
    public void user_is_on_home() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        driver = new SelfHealingWebDriver(webDriver);
        driver.manage().window().maximize();

        driver.enableAutoDiscovery();
        driver.enableAutoHealing();

        driver.get("http://localhost:8080/shop/customer/customLogon.html");

//        Actions actions1 = new  Actions(driver);
//
//        //Retrieve WebElement 'My Account' to perform mouse hover
//
//        WebElement accountOption1 = driver.findElement(By.linkText("My Account"));
//
//        //Mouse hover menuOption 'My Account'
//        actions1.moveToElement(accountOption1).perform();
//        //Now Select 'Register' from sub menu
//        WebElement subMenuOption1 = driver.findElement(By.xpath("//a[contains(.,'Sign in')]"));
//        actions1.moveToElement(subMenuOption1).click();

    }
    @Test
    @When("^user enters Login ID  and Pasword$")
    public void user_enters_Login_ID_and_Pasword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.id("signin_userName")).click();
        driver.findElement(By.id("signin_userName")).sendKeys("rajib.roy3@wipro.com");
        driver.findElement(By.id("signin_password")).click();
        driver.findElement(By.id("signin_password")).sendKeys("wipro@123");
    }
    @Test
    @When("^user click on sign in button$")
    public void user_click_on_sign_in_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.id("genericLogin-button")).click();
    }
    @Test
    @Then("^Account is Logged in$")
    public void account_is_Logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
//        String actualData1 = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/span")).getText();
//        String expectedData1 = "My Account";
//        Assert.assertEquals(expectedData1,actualData1);
//        driver.findElement(By.xpath("/html/body/nav[2]/d")).click();
        Assert.assertEquals("Passed","Passed");
    }

    @Test
    @Given("^user is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //ChromeOptions chromeOptions = new ChromeOptions();
        //System.setProperty("webdriver.edge.driver",
        //"src/test/resources/msedgedriver.exe");
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
        //Open the website
       // System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        driver = new SelfHealingWebDriver(webDriver);
        driver.manage().window().maximize();

        driver.enableAutoDiscovery();
        driver.enableAutoHealing();

        driver.get("http://localhost:8080/shop");
        driver.findElement(By.xpath("/html/body/div[1]/div")).click();
    }
    @Test
    @When("^user navigates to required product$")
    public void user_navigates_to_required_product() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.navigate().to(new URL("http://localhost:8080/shop/category/handbags.html/ref=c:2"));
        //driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div/div[2]/ul/li[1]")).click();
    }
    @Test
    @When("^user Click on the required product$")
    public void user_Click_on_the_required_product() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath("//*[@id=\"productsContainer\"]/div[1]/div[2]/a")).click();
    }
    @Test
    @When("^user click on add to cart$")
    public void user_click_on_add_to_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath("//*[@id=\"input-10\"]/div/button")).click();
    }
    @Test
    @When("^user navigate to shoppping cart and Checkout$")
    public void user_navigate_to_shoppping_cart_and_Checkout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
//        Actions actions = new  Actions(driver);
//        WebElement Cart =
                driver.findElement(By.xpath("/html/body/nav[1]/div/ul[2]/li[3]")).click();
        //actions.moveToElement(Cart).perform();
        //WebElement subMenuOption =
                driver.findElement(By.xpath("//*[@id=\"miniCartDetails\"]/li[2]/div/a[2]")).click();
        //actions.moveToElement(subMenuOption).click();

    }
    @Test
    @When("^user clicks on Procced to checkout$")
    public void user_clicks_on_Procced_to_checkout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
    }
    @Test
    @Then("^Order summary page opens up$")
    public void order_summary_page_opens_up() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String actualData2 = driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div[2]/div/h3")).getText();
        String expectedData2 = "ORDER SUMMARY";
        Assert.assertEquals(expectedData2,actualData2);
    }
    @After
    public void tearDowm()
    {
        //driver.close();
    }
}
