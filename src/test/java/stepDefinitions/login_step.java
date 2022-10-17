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


public class login_step {
	
	WebDriver driver;
	String parentWindowId;
	String childWindowId;


@Given("user is already on front page")
public void user_is_already_on_front_page() {
	WebDriverManager.chromedriver().setup();		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.issuewire.com/");
}


@When("title of front page is IssueWire")
public void title_of_front_page_is_issue_wire() {
	String title = driver.getTitle();
	Assert.assertEquals("Press Release Distribution Services | Paid Press Release Distribution", title);
}

@Then("click to the login button")
public void click_to_the_login_button() {
    driver.findElement(By.linkText("Login")).click();
}


@Then("user enters user name")
public void user_enters_user_name() {
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pijus@elphilltechnology.com");
}

@Then("user enters password")
public void user_enters_password() {
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pijus2105@");
}

@Then("user clicks on login button")
public void user_clicks_on_login_button() {
	driver.findElement(By.xpath("//input[@id='submit-btn1']")).click();
}

@Then("click to the add credit button")
public void click_to_the_add_credit_button() {
    driver.findElement(By.xpath("//i[@class='fa fa-credit-card-alt fa-5x']")).click();
}

@And("new window will be open")
public void new_window_will_be_open() {
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

@Then("dropdown will do select")
public void dropdown_will_do_select() {
	Select se = new Select(driver.findElement(By.xpath("//select[@id='multipck_value1']")));
	 
	 se.selectByValue("5");
}

@Then("return to the home page")
public void return_to_the_home_page() {
	driver.switchTo().window(parentWindowId); 
}


}
