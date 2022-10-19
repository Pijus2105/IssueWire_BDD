package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class tagging {

	WebDriver driver;
	String parentWindowId;
	String childWindowId;


    @Given("^User is on the IssueWire Landing Page$")
    public void user_is_on_the_issuewire_landing_page() throws Throwable 
    {
    	WebDriverManager.chromedriver().setup();		
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.issuewire.com/");
    	String title = driver.getTitle();
    	Assert.assertEquals("Press Release Distribution Services | Paid Press Release Distribution", title);
    	driver.findElement(By.linkText("Login")).click();
    }

    @When("^User give username \"([^\"]*)\" and password\"([^\"]*)\" and click on Login Button$")
    public void user_give_username_something_and_passwordsomething_and_click_on_login_button(String strArg1, String strArg2) throws Throwable 
    {
    	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(strArg1);
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(strArg2);
    	driver.findElement(By.xpath("//input[@id='submit-btn1']")).click();
    	
    }

    @Then("^Home page will be diaplayed and click on Add Credit$")
    public void home_page_will_be_diaplayed_and_click_on_add_credit() throws Throwable {
    	 driver.findElement(By.xpath("//i[@class='fa fa-credit-card-alt fa-5x']")).click();
    	 
    	 Set<String> hand = driver.getWindowHandles();
         Iterator<String> it = hand.iterator();
       	 		   	
       	parentWindowId = it.next();
      	System.out.println("print" + parentWindowId);
       	System.out.println("parent title" + driver.getTitle());
       	
       	childWindowId = it.next();
       	System.out.println("print" + childWindowId);
       
       	
       	System.out.println("child title" + driver.getTitle());
       	
    	driver.switchTo().window(childWindowId);
        
    }

    @And("^select the drop Down$")
    public void select_the_drop_down() throws Throwable {
    	Select se = new Select(driver.findElement(By.xpath("//select[@id='multipck_value1']")));
   	 
   	 se.selectByValue("5");
        
    }



}
