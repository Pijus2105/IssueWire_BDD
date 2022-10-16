package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login_step {
	
	WebDriver driver;
		

	
	@Given("user is already on login pages")
	
	public void login() {
		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		driver.get("https://www.issuewire.com/userlogin");
		
	}
		
	
	@When("^title of login page is IssueWire$")
	public void title_of_login_page_is_issue_wire() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Submit Your Press Release | Press Release Distribution Software", title);
	   
	}
	@Then("^user enters user name$")
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



	
}
